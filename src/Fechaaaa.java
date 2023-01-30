public interface Fechaaaa {
    default int diasMesBisiesto() {

        int diasMes;

        if ((getAnio() % 400 == 0) || ((getAnio() % 4 == 0) && (getAnio() % 100 != 0))) {

            diasMes = 29;
        } else {

            diasMes = 28;
        }

        return diasMes;
    }

    int getAnio();
}
