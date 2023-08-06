package ku.cs.services;

import ku.cs.models.MyMan;
import ku.cs.models.MyManList;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class MyManListFileDatasource implements Datasource<MyManList> {
    private String directoryName;
    private String fileName;

    public MyManListFileDatasource(String directoryName, String fileName) {
        this.directoryName = directoryName;
        this.fileName = fileName;
        checkFileIsExisted();
    }

    private void checkFileIsExisted() {
        File file = new File(directoryName);
        if (!file.exists()) {
            file.mkdirs();
        }
        String filePath = directoryName + File.separator + fileName;
        file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public MyManList readData() {
        MyManList myMan = new MyManList();
        String filePath = directoryName + File.separator + fileName;
        File file = new File(filePath);

        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        InputStreamReader inputStreamReader = new InputStreamReader(
                fileInputStream,
                StandardCharsets.UTF_8
        );
        BufferedReader buffer = new BufferedReader(inputStreamReader);

        String line = "";
        try {
            while ( (line = buffer.readLine()) != null ){
                if (line.equals("")) continue;

                String[] data = line.split(",");

                String sex = data[0].trim();
                String name = data[1].trim();
                String age = data[2].trim();
                Double price = Double.parseDouble(data[3].trim());

                myMan.addNewMyMan(sex, name, age, price);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return myMan;
    }

    @Override
    public void writeData(MyManList data) {
        //MyManList myMan = new MyManList();
        String filePath = directoryName + File.separator + fileName;
        File file = new File(filePath);

        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                fileOutputStream,
                StandardCharsets.UTF_8
        );

        BufferedWriter buffer = new BufferedWriter(outputStreamWriter);

        try {
            for (MyMan boy : data.getMyMans()) {
                String line = boy.getSex() + "," + boy.getName() + "," + boy.getAge2() + "," + boy.getPrice();
                buffer.append(line);
                buffer.append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                buffer.flush();
                buffer.close();
            } catch (IOException e){
                throw new RuntimeException(e);
            }
        }



        /*InputStreamReader inputStreamReader = new InputStreamReader(
                fileInputStream,
                StandardCharsets.UTF_8
        );
        BufferedReader buffer = new BufferedReader(inputStreamReader);

        String line = "";
        try {
            while ( (line = buffer.readLine()) != null ){
                if (line.equals("")) continue;

                String[] data = line.split(",");

                String sex = data[0].trim();
                String name = data[1].trim();
                int age = Integer.parseInt(data[2].trim());
                Double price = Double.parseDouble(data[2].trim());

                myMan.addNewMyMan(sex, name, age, price);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return myMan;*/
    }
}