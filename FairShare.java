import java.util.ArrayList;
import java.util.Set;

public class FairShare {
    private Set<sProcess> processSet;
    private sProcess currentProcess = null;

    public FairShare(Set<sProcess> processSet) {
        this.processSet = processSet;
        currentProcess = processSet.iterator().next();
    }

    public sProcess changeProcess() {
        ArrayList<sProcess> toRemove = new ArrayList<sProcess>();
        for(sProcess process : processSet) {
            if (process.cpudone < process.cputime && currentProcess != process) { 
                currentProcess = process;
                return currentProcess;
            }

            if (process.cpudone == process.cputime) {
                toRemove.add(process);
            }
        }

        for(sProcess process : toRemove) {
            processSet.remove(process);
        }
    
        return currentProcess;
    }

    public void updateTimeElapsed(sProcess process, int newTimeElapsed) {
        processSet.remove(process);
        process.cpudone = newTimeElapsed;
        processSet.add(process);
    }
}
