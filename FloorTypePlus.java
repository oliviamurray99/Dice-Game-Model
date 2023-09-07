public class FloorTypePlus extends FLOORTYPE {
    protected String description = "";
    protected int quantity = 0;

    public FloorTypePlus(String csvLine) {
        String [] data = csvLine.split("\\|");
        this.name = data[0];
        this.cost = Double.parseDouble(data[1]);
        this.description = data[2];
        this.quantity = Integer.parseInt(data[3]);

    }//FloorTypePlus(String csvLine)

    public void SellQuantity(int qty){
        quantity -=qty;
    }

    public int getQuantity() {
        return quantity;
    }

    public String toCSV(){
        return name+"|"+cost+"|"+description+"|"+quantity;
    }

    public String toString(){
        return "type="+ this.name + "; cost="+this.cost+"; desc="+this.description+"; quant="+this.quantity;
    }


    public boolean contains(String item){
        boolean found = false;

        if (this.name.toLowerCase().indexOf(item.toLowerCase())>-1){
            found = true;
        }//end if
        return found;
    }//boolean contains (String item)
}
