import java.util.Objects;

public class sProcess implements Comparable<sProcess> {
  public int cputime;
  public int ioblocking;
  public int cpudone;
  public int ionext;
  public int numblocked;
  
  private int id;
  private static int current_id = 0;

  public sProcess (int cputime, int ioblocking, int cpudone, int ionext, int numblocked) {
    this.cputime = cputime;
    this.ioblocking = ioblocking;
    this.cpudone = cpudone;
    this.ionext = ionext;
    this.numblocked = numblocked;
    this.id = current_id++;
  }

  @Override
  public int compareTo(sProcess o) {
    int t = cpudone - o.cpudone;
    return t != 0 ? t : Integer.compare(id, o.id);
  }

  @Override
  public boolean equals(Object o) {
    if(o == this) return true;
    if(!(o instanceof sProcess)) {
      return false;
    }

    sProcess p = (sProcess)o;

    return id == p.id;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}
