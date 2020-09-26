package nano;

import nano.dbConnect.DBConnect;

public class Main {

    public static void main(String[] args) {
        new DBConnect().connect();
    }
}
