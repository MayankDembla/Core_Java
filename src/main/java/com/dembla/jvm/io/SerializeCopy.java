package com.dembla.jvm.io;

import java.io.*;

public class SerializeCopy {

    public  static  class SerializeDemo implements  Serializable{

        SerializeDemo(String name , int id ){
            this.name = name ;
            this.id = id ;
        }

        private String name ; 
        private transient  int id  = 5 ;

        private String futurevariable ;

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
        
        if(args.length > 0 && args[0].equals("true"))
                doSerialize();
        
        dodeserialize(); 
    }

    private static void doSerialize() {
        System.out.println("/n Inside the Serialize Method ");

       SerializeDemo serializableDemo = new SerializeDemo("Mayank",5 ) ;
        System.out.println("Before Serialization value of variable is ");
        System.out.println("Name : " + serializableDemo.getName());
        System.out.println("Id : " + serializableDemo.getId());

        try(ObjectOutputStream out = new ObjectOutputStream( new BufferedOutputStream( new FileOutputStream("newobject.ser")) )){

            out.writeObject(serializableDemo);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void dodeserialize() {

        System.out.println("Inside the Desrialization  Method ");


        try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("newobject.ser")))){

            SerializeDemo serializableDemo = (SerializeDemo) in.readObject();

            System.out.println("Before the Deserialization values are ");
            System.out.println("Name : " + serializableDemo.getName());
            System.out.println("Id : " + serializableDemo.getId());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
