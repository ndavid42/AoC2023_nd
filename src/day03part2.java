import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class day03part2 {
    public static void part1() throws IOException {
        System.out.println("day3 part2");
        String file = "./input03/data.txt";
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        int rows = 0;
        int cols = 0;
        while ((line = br.readLine()) != null) {
            cols = line.length();
            rows += 1;
        }
        System.out.println("r: " + rows + ", c: " + cols + "\n");//


        char[][] engine = new char[rows+2][cols+2];


        br = new BufferedReader(new FileReader(file));
        for (int i = 0; i < cols+2; i++) {
            engine[0][i] = '.'; //hogy legyen egy "keret FELÜL"
        }

        int lineNum = 0;
        while ((line = br.readLine()) != null) {
            engine[lineNum+1][0] = '.'; //hogy legyen egy "keret BAL OLDALT"

            for (int c = 0; c < line.length(); c++) {
//                System.out.print(line.charAt(c) + "");
                engine[lineNum+1][c+1] = line.charAt(c);             // EZ NAGYON FONTOS!! ez készíti a csekkolós táblát
            }

            engine[lineNum+1][cols+1] = '.'; //hogy legyen egy "keret JOBB OLDALT"
            lineNum++;
        }

        for (int i = 0; i < cols+2; i++) {
            engine[rows+1][i] = '.'; //hogy legyen egy "keret ALUL"
        }

//        //ábra kirajzolás
//        for (int n = 0; n < rows+2; n++) {
//            for (int m = 0; m < cols+2; m++) {
////                System.out.println("r" + n + "/c" + m + ": " +engine[n][m]);
//                System.out.print(engine[n][m]);
//            }
//            System.out.println();
//        }
//        System.out.println("\n--- --- ---");




        ArrayList<Integer> partNumberList = new ArrayList<>();
        ArrayList<enginePart> allTheParts = new ArrayList<>();
        int sumOfPartNumbers = 0;

        //jön a feltöltött engine tömb végigcsekkolása
        for (int row = 0; row < rows + 2; row++) {
            boolean prevWasDigit = false; //az előző digit volt-e
            String partNumber = "";

            for (int col = 0; col < cols+2; col++) {
                char c = engine[row][col];              //aktuálisan vizsgált karakter

//                System.out.print(c);
                if (isDigit(c)) {
                    partNumber = partNumber + c;
                    prevWasDigit = true;

//                    System.out.println(partNumber);
                } else {
                    if (prevWasDigit) {
                        partNumberList.add(Integer.parseInt(partNumber));
//                        System.out.println("part added to list! " + Integer.parseInt(partNumber));

                        allTheParts.add(new enginePart(Integer.parseInt(partNumber),row,col));
                        partNumber = "";

                    }
                    prevWasDigit = false;
                }



            }
//            System.out.println();
        } // engine végigellenőrzés vége



//        int x = 5;
//        System.out.println("\n1. art pn: " + allTheParts.get(x).getEnginePartNumber());
//        System.out.println("1. art pn len: " + allTheParts.get(x).getPartNumberLength() + " (" + allTheParts.get(x).getRow() + "," + allTheParts.get(x).getCol() + ")");
//
//        System.out.println("num of parts: " + partNumberList.size());
//        System.out.println("");


//
////         és most jön a végigcsekkolás
        for (int q = 0; q < allTheParts.size(); q++) {
            //az egyes partoknál megnézi, h a körbefoglaló négyszögben van-e symbol

            boolean ezaz = false;
            enginePart e = allTheParts.get(q);
            for (int b = 0; b < 3; b++) {
                for (int a = 0; a < e.getPartNumberLength() + 2; a++) {
//                    System.out.print(engine[e.row - 1 + b][e.col + a - 1]);
                    if (isSymbol(engine[e.row - 1 + b][e.col + a - 1])) {
                        e.setSym(engine[e.row - 1 + b][e.col + a - 1]);
                        e.setSym_row(e.row - 1 + b);
                        e.setSym_col(e.col + a - 1);
                        sumOfPartNumbers += e.getEnginePartNumber();
                        ezaz = true;
                    }
                }
//                System.out.println();
            }
            if (ezaz) {
//                System.out.println("EZ AZ!");
            }
//            System.out.println("\n");
        }

        System.out.println("\nhow many parts: " + allTheParts.size());
        System.out.println("partnumbers sum: " + sumOfPartNumbers);


        ArrayList<gear> gearedParts = new ArrayList<>();
        //part2 fogaskerekes rész
        for (int q = 0; q < allTheParts.size(); q++) {
            enginePart e = allTheParts.get(q);
            char sym = e.getSym();
            if (sym == '*') {
//                System.out.println(e.getEnginePartNumber() + " has a gear!");

                boolean letezik = false;
                
                gear letez = null;
                for (int x = 0; x < gearedParts.size(); x++) {
                    if ((e.getSym_row() * 100 + e.getSym_col()) == gearedParts.get(x).getId()) {
                        letezik = true;
                        letez = gearedParts.get(x);
                    }
                }
                if (!letezik) {
                    gearedParts.add(new gear(e.getSym_row(), e.getSym_col(), e));
                } else {
                    letez.setConnectedParts(e);
                }
            }
        }


        for (int g = 0; g < gearedParts.size(); g++) {
            System.out.println("parts connected to this gear: " + gearedParts.get(g).connectedParts.size() + " (" + gearedParts.get(g).getSym_row() + ", " + gearedParts.get(g).getSym_col() + " --> " + gearedParts.get(g).getId() + ")");
        }

        int gearedPartsAnswer = 0;
        for (int g = 0; g < gearedParts.size(); g++) {
            if (gearedParts.get(g).connectedParts.size() == 2) {
                System.out.println(gearedParts.get(g).connectedParts.get(0).getEnginePartNumber() + "*" + gearedParts.get(g).connectedParts.get(1).getEnginePartNumber());
                gearedPartsAnswer += gearedParts.get(g).connectedParts.get(0).getEnginePartNumber() * gearedParts.get(g).connectedParts.get(1).getEnginePartNumber();
            }
        }

        System.out.println("\n part2 answer: " + gearedPartsAnswer);
//jaa, mondjuk valsz új gearekat rak fel...
// kéne csekkolni, h létezik-e már az adott gear, és ahhoz rakni a part kapcsolást

    }




    public static class gear {
        private int sym_row;
        private int sym_col;
        ArrayList<enginePart> connectedParts = new ArrayList<>();
        private  int id;


        public gear(int sym_row, int sym_col, enginePart part) {
            this.sym_row = sym_row;
            this.sym_col = sym_col;
            this.setConnectedParts(part);
            id = sym_row * 100 + sym_col;
        }

        public int getId() {
            return id;
        }


        public int getSym_row() {
            return sym_row;
        }

        public void setSym_row(int sym_row) {
            this.sym_row = sym_row;
        }

        public int getSym_col() {
            return sym_col;
        }

        public void setSym_col(int sym_col) {
            this.sym_col = sym_col;
        }

        public void setConnectedParts(enginePart part) {
            connectedParts.add(part);
//            System.out.println("part set to gear");
        }
    }

    public static class enginePart {
        private int enginePartNumber;
        private int PartNumberLength;
        private int row;
        private int col;
        private char sym;
        private int sym_row;
        private int sym_col;

        public enginePart(int enginePartNumber, int row, int col) {
            this.enginePartNumber = enginePartNumber;
            this.row = row;
            this.col = col - this.getPartNumberLength();
//            System.out.println("new enginePart!");
        }

        public int getEnginePartNumber() {
            return enginePartNumber;
        }

        public void setEnginePartNumber(int enginePartNumber) {
            this.enginePartNumber = enginePartNumber;
        }

        public int getPartNumberLength() {
            PartNumberLength = String.valueOf(this.enginePartNumber).length();
            return PartNumberLength;
        }

        public void setPartNumberLength(int partNumberLength) {
            PartNumberLength = partNumberLength;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }

        public char getSym() {
            return sym;
        }

        public void setSym(char sym) {
            this.sym = sym;
        }

        public int getSym_row() {
            return sym_row;
        }

        public void setSym_row(int sym_row) {
            this.sym_row = sym_row;
        }

        public int getSym_col() {
            return sym_col;
        }

        public void setSym_col(int sym_col) {
            this.sym_col = sym_col;
        }
    }



    public static boolean isDigit ( char c){
        boolean isnum = false;
        if ((((int) c) >= 48) && (((int) c) <= 57)) {
            isnum = true;
        }
        return isnum;
    }

    public static boolean isSymbol ( char c){
        boolean issym = false;
//        if ((((int) c)-48) < -2) {
        if(!isDigit(c) && (c != '.')) {
            issym = true;
        }
        return issym;
    }

    public static void part2() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input03/test1.txt"));
        String line;

        while ((line = br.readLine()) != null) {
            System.out.println("input line: " + line);


        }
//            System.out.println("D2P1");

    }
}

//part1
// 546563 !!!

//part2
// 90332842 too low