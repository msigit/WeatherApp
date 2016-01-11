package weatherapp.msi.com.weatherapp.ApplicationHelpers;

/**
 * Created by MSi on 11/7/2015.
 */
public class StaticService {

    public static String Condition64Img(String ConditionCode)
    {
        if(ConditionCode.equals(null) || ConditionCode.equals(""))
        {
            ConditionCode = "http://i64.tinypic.com/b51i6q.jpg";
        }
        else {

            switch (ConditionCode) {
                case "3200":
                    ConditionCode = "http://i64.tinypic.com/b51i6q.jpg";
                    break;
                case "47":
                    ConditionCode = "http://i65.tinypic.com/11kjejs.jpg";
                    break;
                case "46":
                    ConditionCode = "http://i66.tinypic.com/ibl8c5.jpg";
                    break;
                case "45":
                    ConditionCode = "http://i65.tinypic.com/11kjejs.jpg";
                    break;
                case "44":
                    ConditionCode = "http://i66.tinypic.com/1zlxk4j.jpg";
                    break;
                case "43":
                    ConditionCode = "http://i66.tinypic.com/ibl8c5.jpg";
                    break;
                case "42":
                    ConditionCode = "http://i66.tinypic.com/ibl8c5.jpg";
                    break;
                case "41":
                    ConditionCode = "http://i66.tinypic.com/ibl8c5.jpg";
                    break;
                case "40":
                    ConditionCode = "http://i66.tinypic.com/35015dg.jpg";
                    break;
                case "39":
                    ConditionCode = "http://i64.tinypic.com/selwma.jpg";
                    break;
                case "38":
                    ConditionCode = "http://i64.tinypic.com/selwma.jpg";
                    break;
                case "37":
                    ConditionCode = "http://i65.tinypic.com/11kjejs.jpg";
                    break;
                case "36":
                    ConditionCode = "http://i64.tinypic.com/2wgi1on.jpg";
                    break;
                case "35":
                    ConditionCode = "http://i66.tinypic.com/2q1f9k3.jpg";
                    break;
                case "34":
                    ConditionCode = "http://i64.tinypic.com/2wp87xu.jpg";
                    break;
                case "33":
                    ConditionCode = "http://i64.tinypic.com/2ahiff8.jpg";
                    break;
                case "32":
                    ConditionCode = "http://i68.tinypic.com/35bc8pv.jpg";
                    break;
                case "31":
                    ConditionCode = "http://i67.tinypic.com/mvi33b.jpg";
                    break;
                case "30":
                    ConditionCode = "http://i65.tinypic.com/24pypu0.jpg";
                    break;
                case "29":
                    ConditionCode = "http://i66.tinypic.com/fdyttt.jpg";
                    break;
                case "28":
                    ConditionCode = "http://i65.tinypic.com/24pypu0.jpg";
                    break;
                case "27":
                    ConditionCode = "http://i66.tinypic.com/fdyttt.jpg";
                    break;
                case "26":
                    ConditionCode = "http://i66.tinypic.com/1zlxk4j.jpg";
                    break;
                case "25":
                    ConditionCode = "http://i64.tinypic.com/2ikqzom.jpg";
                    break;
                case "24":
                    ConditionCode = "http://i68.tinypic.com/1zflhf4.jpg";
                    break;
                case "23":
                    ConditionCode = "http://i68.tinypic.com/1zflhf4.jpg";
                    break;
                case "22":
                    ConditionCode = "http://i63.tinypic.com/fapw7l.jpg";
                    break;
                case "21":
                    ConditionCode = "http://i68.tinypic.com/vynq6r.jpg";
                    break;
                case "20":
                    ConditionCode = "http://i68.tinypic.com/2mplpn9.jpg";
                    break;
                case "19":
                    ConditionCode = "http://i68.tinypic.com/2mplpn9.jpg";
                    break;
                case "18":
                    ConditionCode = "http://i66.tinypic.com/25ft6ax.jpg";
                    break;
                case "17":
                    ConditionCode = "http://i66.tinypic.com/25ft6ax.jpg";
                    break;
                case "16":
                    ConditionCode = "http://i64.tinypic.com/2mqnsl5.jpg";
                    break;
                case "15":
                    ConditionCode = "http://i64.tinypic.com/2mqnsl5.jpg";
                    break;
                case "14":
                    ConditionCode = "http://i64.tinypic.com/2mqnsl5.jpg";
                    break;
                case "13":
                    ConditionCode = "http://i64.tinypic.com/2mqnsl5.jpg";
                    break;
                case "12":
                    ConditionCode = "http://i68.tinypic.com/2ecd9xh.jpg";
                    break;
                case "11":
                    ConditionCode = "http://i68.tinypic.com/2ecd9xh.jpg";
                    break;
                case "10":
                    ConditionCode = "http://i68.tinypic.com/2ecd9xh.jpg";
                    break;
                case "9":
                    ConditionCode = "http://i68.tinypic.com/2ecd9xh.jpg";
                    break;
                case "8":
                    ConditionCode = "http://i68.tinypic.com/2ecd9xh.jpg";
                    break;
                case "7":
                    ConditionCode = "http://i66.tinypic.com/2q1f9k3.jpg";
                    break;
                case "6":
                    ConditionCode = "http://i66.tinypic.com/2q1f9k3.jpg";
                    break;
                case "5":
                    ConditionCode = "http://i66.tinypic.com/2q1f9k3.jpg";
                    break;
                case "4":
                    ConditionCode = "http://i64.tinypic.com/38mmu.jpg";
                    break;
                case "3":
                    ConditionCode = "http://i64.tinypic.com/38mmu.jpg";
                    break;
                case "2":
                    ConditionCode = "http://i65.tinypic.com/1435e8.jpg";
                    break;
                case "1":
                    ConditionCode = "http://i67.tinypic.com/2lsxn3a.jpg";
                    break;
                case "0":
                    ConditionCode = "http://i67.tinypic.com/2lsxn3a.jpg";
                    break;
                default:
                    ConditionCode = "http://i64.tinypic.com/b51i6q.jpg";
                    break;
            }
        }
        return ConditionCode;
    }


    public static String Day(String day)
    {
        if(day.equals(null) || day.equals(""))
        {
            day = "Server Error";
        }
        else
        {
            switch (day) {
                case "Fri":
                    day = "Friday";
                    break;

                case "Thu":
                    day = "Thursday";
                    break;

                case "Wed":
                    day = "Wednesday";
                    break;
                case "Tue":
                    day = "Tuesday";
                    break;

                case "Mon":
                    day = "Monday";
                    break;

                case "Sun":
                    day = "Sunday";
                    break;

                case "Sat":
                    day = "Saturday";
                    break;

                default:
                    break;
            }
        }
        return day;
    }
}
