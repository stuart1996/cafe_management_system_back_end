package com.ouedraogo_issaka.cafe_management_system.utilaires;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.google.common.base.Strings;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CafeUtilitaires {

    private CafeUtilitaires() {

    }

    public static ResponseEntity<String> getResponseEntity(String responseMassage, HttpStatus httpStatus) {
        return new ResponseEntity<String>("{\"message\":\"" + responseMassage + "\"}", httpStatus);
    }

    public static String getUUID() {
        Date date = new Date();
        long minute = date.getTime();

        return "FACTURE- " + minute;
    }

    public static JSONArray getJsonArrayFromString(String donnee) throws JSONException {
        JSONArray jsonArray = new JSONArray(donnee);
        return jsonArray;
    }

    public static Map<String, Object> getMapFromJson(String donnee) {
        if (!Strings.isNullOrEmpty(donnee)) {
            return new Gson().fromJson(donnee, new TypeToken<Map<String, Object>>() {
            }.getType());
        }
        return new HashMap<>();
    }

    public static Boolean isFichierExiste(String path) {
        log.info("À l'intérieur du isFichierExiste {}", path);

        try {
            File file = new File(path);

            return (file != null && file.exists()) ? Boolean.TRUE : Boolean.FALSE;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}