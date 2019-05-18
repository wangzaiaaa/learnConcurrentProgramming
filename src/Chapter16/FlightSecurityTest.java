package Chapter16;

public class FlightSecurityTest {
    static class Passengers extends Thread{
        private FlighSecurity flighSecurity;
        private String idCard;
        private String boardingPass;
        public Passengers(FlighSecurity flighSecurity,String idCard,String boardingPass){
            this.flighSecurity = flighSecurity;
            this.idCard = idCard;
            this.boardingPass = boardingPass;
        }
        @Override
        public void run(){
            while (true){
                flighSecurity.pass(boardingPass,idCard);
            }
        }
    }
    public static void main(String [] args){
        final FlighSecurity flighSecurity = new FlighSecurity();
        new Passengers(flighSecurity,"A123456","AF123456");
        new Passengers(flighSecurity,"B123456","BF123456");
        new Passengers(flighSecurity,"C123456","CF123456");
    }
}
