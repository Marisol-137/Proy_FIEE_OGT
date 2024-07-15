package com.mycompany.proyecto;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.gson.Gson;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import javax.xml.transform.Source;

public class Usuario {

    static private String[] user = new String[1];
    static private String[] pass = new String[1];

    public Usuario() {
    }

    public Usuario(String usuario, String contrasena) {
        this.user[0] = usuario;
        this.pass[0] = contrasena;
    }

    public void setUser(String user) {
        this.user[0] = user;
    }

    public void setPass(String pass) {
        this.pass[0] = pass;
    }

    public String getUser() {
        return user[0];
    }

    public String getPass() {
        return pass[0];
    }

    //
    CollectionReference reference;
    
    static Firestore db;
    
    public static boolean guardarPersona(String coleccion, String documento,
            Map<String, Object> data){
        db = FirestoreClient.getFirestore();
        
        try {
            DocumentReference docRef = db.collection(coleccion).document(documento);
            ApiFuture<WriteResult> result = docRef.set(data);
            System.out.println("Guardado correcto");
            return true;
        } catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
       return false; 
    }
    
        public static String CargarDato(String coleccion, String documento, String campo) {
            db = FirestoreClient.getFirestore();

            try {
                DocumentReference docRef = Conexion.db.collection(coleccion).document(documento);
                ApiFuture<DocumentSnapshot> future = docRef.get();
                DocumentSnapshot document = future.get();

                if (document.exists()) {
                    String jsonData = document.getString(campo);
                    return jsonData;
                } else {
                    System.out.println("El documento no existe.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        return null;
    }
    
}

   


