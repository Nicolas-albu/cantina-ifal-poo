package com.ifal.cantina.reflections;

import com.ifal.cantina.annotations.DBField;
import com.ifal.cantina.annotations.Table;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class Database {
    Connection connectionDatabase;

    public Database(Connection connection) {
        this.connectionDatabase = connection;
    }

    public void insert(Object entity) throws IllegalAccessException {
        Table tableEntity = entity.getClass().getAnnotation(Table.class);
        String sql;

        if (tableEntity != null) {
            String tableName = tableEntity.tableName();
            Map<String, String> dataSearchOfEntity = dataSearch(entity);
            sql = buildSql(tableName, dataSearchOfEntity);
        }
    }

    private Map<String, String> dataSearch(Object entity) throws IllegalAccessException {
        Field[] entityFields = entity.getClass().getDeclaredFields();
        Map<String, String> dataSql = new HashMap<>();

        for (Field field : entityFields) {
            field.setAccessible(true); // Pass the private attributes as visible.
            DBField tableField = field.getAnnotation(DBField.class);

            if (tableField != null) {
                String fieldName = tableField.fieldName();

                dataSql.put(fieldName, field.get(entity).toString());
            }
        }

        return dataSql;
    }

    private String buildSql(String tableName, Map<String, String> dataSql) {
        StringBuilder statementSql = new StringBuilder();

        for (String entityField : dataSql.keySet()) {
            if (!statementSql.toString().equals(""))
                statementSql.append(", ");

            String valueField = dataSql.get(entityField);

            statementSql.append(String.format("%s = '%s'", entityField, valueField));
        }

        return String.format("INSERT INTO %s VALUES(%s);",
                tableName, statementSql.toString());
    }
}




//
//class Repositorio {
//
//    public void insert(Object obj) throws Throwable {
//        // Tenta obter nossa anotação na classe
//        DBTable persistable =
//                obj.getClass().getAnnotation(DBTable.class);
//
//        if (persistable != null) {
//            buildSql();
//        }
//
//    }
//
//    public void buildSql() {
//
//        // Se tiver a anotação...
//            String tabela = persistable.table();
//            // Map para montar o SQL campo/valor :)
//            HashMap keyAndValues = new HashMap();
//
//            // Obtém os atributos da classe via reflection
//            Field[] fields = getFields(obj.getClass());
//            for (Field field : fields) {
//                // como os atributos são private, colocamos ele como visible
//                field.setAccessible(true);
//                DBField coluna = field.getAnnotation(DBField.class);
//
//                // Se o atributo tem a anotação
//                if (coluna != null){
//                    // Verifica se está vazio pra usar o
//                    // nome do próprio atributo
//                    String columnName =
//                            coluna.colummn().equals("") ?
//                                    field.getName() : coluna.colummn();
//
//                    // Adiciona campo/valor no map
//                    keyAndValues.put(
//                            columnName, field.get(obj).toString());
//                }
//            }
//
//            // Varre o map para montar o SQL
//            String values = "";
//            Set keys = keyAndValues.keySet();
//            for (String campo: keys) {
//                if (!values.equals("")) values += ",";
//                String valor = keyAndValues.get(campo);
//                values += campo +"='"+ valor +"'";
//            }
//
//            String sql = "INSERT INTO "+ tabela +
//                    " values("+ values +")";
//            System.out.println("SQL---->"+ sql);
//    }
//
//    // Método recursivo para obter os atributos da
//    // class e da superclasse
//    public Field[] getFields(Class c){
//        // Se tem superclasse
//        if (c.getSuperclass() != null){
//            // Chama o próprio método para pegar os
//            // atributos da superclasse
//            Field[] superClassFields =
//                    getFields(c.getSuperclass());
//            // Pega os atributos da própria classe
//            Field[] thisFields = c.getDeclaredFields();
//
//            // array com todos os atributos
//            Field[] allFields = new Field[
//                    superClassFields.length +
//                            thisFields.length];
//
//            // Copia os atributos da superclasse
//            System.arraycopy(superClassFields, 0,
//                    allFields, 0, superClassFields.length);
//            // Copia os atributos da classe atual
//            System.arraycopy(thisFields, 0, allFields,
//                    superClassFields.length, thisFields.length);
//
//            return allFields;
//
//            // Se não tem superclasse, retorna os
//            // próprios atributos
//        } else {
//            return c.getDeclaredFields();
//        }
//    }
//}
