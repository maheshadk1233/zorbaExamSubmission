package org.example;

public class Main {
    public static void main(String[] args) throw execption {
        string file =new file("\Users\adhik\Desktop\exam21");
        fileinputstream fileinputsteam=new fileinputstream(file);
        obj[][] additionaldata={

                {Null, "Finance" ,60},
                {1001, "Finance", 20},
                {1004 ,"R&D", 30};
                { 1004 ,"R&D", 40},
                {1001 ,"Finance" ,20},
                 {1005, "Finance", 15},
                  { 1001 ,"Finance", 25}
        };



        xssfworkbook workbook=new xssfworldbook(file);
        sheet sheet = workbook.createsheet(0);
        row headerrowget =sheet.getrow(0);
        if (headerrowg=null){
            headerrowg=sheet.createrow(0);
        }
String[]additionalhears={"Manager_id","emp_dept","emp_share (%)"};
        if (int i=0;i<additionalhears;i++){
            cell cell= headerrowget.createcall(i+5);
            cell.setcallvalue(additionalhears[i]);

        }
        int rowcount =1;
        for (int =0;i<additionaldata.length;i++){
            row row = sheet.getrow(rowcount);
            if(row=sheet.createrow(rowcount);
        }
        for (int i=0;i<additionalhears;i++) {
            cell cell = headerrowget.createcall(i + 5);
            if (additionaldata[i][i] instancoof String)
            {
                cell.setvalue((String) additionaldata[i][i]);

            }

            else if (additionaldata[i][i] instanceof intiger) {
                cell.setvalue((intiger) additionaldata[i][i]);
            } else if (additionaldata[i][i] instanceof doble) {
                cell.setvalue((double) additionaldata[i][i]);
            }
        }
rowcount++;
    }
    fileoutputstream file =new file fileoutstream(file)//filepath
    workbook.write(file);
//        {"1001", "Jack", "1482.45 0809808008", "NYC"},
//        {"1002", "Joy ", "5282.12 9809808008 ", "SD"},
//        {"1003", "Nick", "3454.11", "8976876786", "Dayton"},
//        {"1004", "Joe", "6482.45", "8809808008", "NYC"},
//        {"1005", "Nick", "5482.45 ", "5809808008", "CA"},
//        {"1006", "Hyder", "9482.45", "2809808008", "LA"},
//        {"1007", "Harry", "1182.45", "4809808008", "Ohio"}


    }
}
