public class Result implements Comparable<Result>{
    private String vName;
    private int turns;

    // private ArrayList<Position> positions;
    public Result(String name,int turns) {
        this.vName = name;
        this.turns = turns;
    }

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    public int getTurns() {
        return turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }

    @Override
    public int compareTo(Result o) {
        int t1  = this.turns;
        int t2  =o.turns;
        if(t1 > t2) {
            return 1;
        }else if(t1<t2) {
            return -1;
        }
        return 0;
    }
}

