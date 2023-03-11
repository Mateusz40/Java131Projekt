package project.Flight;

public enum AirportName {
    GDN, WAW, LUT, WMI, LUZ, RDO;


    @Override
    public String toString() {
        switch(this){
            case GDN :
                return "GDN";
            case WAW :
                return "WAW";
            case LUT :
                return "LUT";
            case WMI :
                return "WMI";
            case LUZ:
                return "LUZ";
            case RDO:
                return "RDO";
        }

        return null;
    }
}
