package com.dembla.jvm.io;

import java.io.*;

public class Serialize {

    public static class SerializableDemo implements Serializable {
        static  final  long serialVersionUID = 8882416L ;
        private String name;
        private transient int id = 4;

        private String gender ;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }


    public static void main(String[] args) {

        if (args.length > 0 && args[0].equals("true")) {
            new Serialize().doSerialization();
        }

        new Serialize().doDeserialization();

    }

    private void doDeserialization() {
        System.out.println("/n Inside Deserialization Method");


        try (ObjectInputStream in = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream("object.ser")))) {

            SerializableDemo serializableDemo = (SerializableDemo) in.readObject();

            System.out.println("After Deserialization : Name " + serializableDemo.getName());
            System.out.println("After Deserialization : Id " + serializableDemo.getId());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    private void doSerialization() {

        System.out.println("\n Inside Do Serialization .. ");

        SerializableDemo serializableDemo = new SerializableDemo();
        serializableDemo.setName("Java");
        System.out.println("Before Serilaizarion :" + serializableDemo.getName());
        System.out.println("Before Serialization : " + serializableDemo.getId());

        try (ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream("object.ser")))) {

            out.writeObject(serializableDemo);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}