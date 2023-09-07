/**
 *
 */

/**
 * @author 45101MUR
 *
 */
public class FLOORTYPE {

    protected String name;
    protected double cost;

    public FLOORTYPE(){

    }



    public FLOORTYPE(String name, double cost){
        this.name =name;
        this.cost=cost;
    }

    public FLOORTYPE(String csvLine) {
        String [] data = csvLine.split("\\|");
        this.name = data[0];
        this.cost = Double.parseDouble(data[1]);

    }

    public String getName(){
        return name;
    }

    public double getCost(){
        return cost;
    }


    public boolean contains(String item){
        boolean found = false;

        if (this.name.toLowerCase().indexOf(item.toLowerCase())>-1){
            found = true;
        }//end if
        return found;
    }//boolean contains (String item)



    }





