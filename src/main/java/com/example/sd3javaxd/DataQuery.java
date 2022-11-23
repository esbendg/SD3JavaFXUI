package com.example.sd3javaxd;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataQuery {
/*
Algorithm is taken from lecture with Mads R (01.11 "Java Database Connector") and adjusted slightly.
 */
    public List<String> getData (){
        List <String> retrievedInfo = new ArrayList<>();
        {
            Connection conn = null;
            try {
                String url = "jdbc:sqlite:identifier.sqlite";
                conn = DriverManager.getConnection(url);
                System.out.println("Got it!");

                Statement stmt=null;
                stmt = conn.createStatement();
                String query = "select id, name from habour;";
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    //Add name of harbour to list that is returned
                    retrievedInfo.add(rs.getInt("id")-1, rs.getString("name"));

                }
                if (stmt != null) { stmt.close(); }

            } catch (SQLException e) {
                throw new Error("Problem", e);
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return retrievedInfo;
    }
    public List<String> findVessel (String Amount){

        List <String> retrievedInfo = new ArrayList<>(12);
                Connection conn = null;
                try {
                    String url = "jdbc:sqlite:identifier.sqlite";
                    conn = DriverManager.getConnection(url);
                    System.out.println("Got it!");

                    Statement stmt=null;
                    stmt = conn.createStatement();

                    String query = "select * from transport join vessel on transport.vessel = vessel.id join flow on transport.id = flow.transport where (capacity - containers) >";
                    ResultSet rs = stmt.executeQuery(query+Amount+";");
                    while (rs.next()) {
                        //Add name of harbour to list that is returned
                        System.out.println(rs.getInt("id")-1+rs.getString("name"));
                        retrievedInfo.add(rs.getInt("id")-1, rs.getString("name"));
                        break;

                    }
                    if (stmt != null) { stmt.close(); }

                } catch (SQLException e) {
                    throw new Error("Problem", e);
                } finally {
                    try {
                        if (conn != null) {
                            conn.close();
                        }
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
        return retrievedInfo;
            }
        }