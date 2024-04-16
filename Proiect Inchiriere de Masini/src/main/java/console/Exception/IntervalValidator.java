package console.Exception;

public class IntervalValidator {

    public void Verif(String line1,String line2) throws ExceptionForYear, ExceptionForMonth, ExceptionForDay {

        int zi1 = Integer.parseInt(line1.split("-")[0]);
        int luna1 = Integer.parseInt(line1.split("-")[1]);
        int an1 = Integer.parseInt(line1.split("-")[2]);

        int zi2 = Integer.parseInt(line2.split("-")[0]);
        int luna2 = Integer.parseInt(line2.split("-")[1]);
        int an2 = Integer.parseInt(line2.split("-")[2]);

        if(an2<an1)
            throw new ExceptionForYear("anul de la data de sfarsit este mai mic decat anul de la data de inceput\n");

        if(an1==an2 && luna2<luna1)
            throw new ExceptionForMonth("luna de la data de sfarsit este mai mica decat luna de la data de inceput\n");

        if(an1==an2 && luna1==luna2 && zi2<zi1)
            throw new ExceptionForDay("ziua de la data de sfarsit este mai mica decat ziua de la data de inceput\n");

    }

}