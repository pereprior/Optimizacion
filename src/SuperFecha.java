public class SuperFecha {
    protected int diasMes() {

        int diasMes = 0;

        switch (getMes()) {

            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                diasMes = 31;
                break;

            case 4:
            case 6:
            case 9:
            case 11:
                diasMes = 30;
                break;

            case 2: // verificación de año bisiesto
                diasMes = diasMesBisiesto();
                break;

        }

        return diasMes;

    }

    private int diasMesBisiesto() {
        return diasMes();
    }

    private int getMes() {
        return diasMes();
    }
}
