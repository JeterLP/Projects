import org.bukkit.event.Listener;
import com.vexsoftware.votifier.model.VotifierEvent;
import com.vexsoftware.votifier.model.Vote;
    
public class VoteListener implements Listener {
    
    @EventHandler(priority=EventPriority.NORMAL)
    public void onVotifierEvent(VotifierEvent event) {
        Vote vote = event.getVote();
        Player player = this.getServer().getPlayer();
    System.out.println("the Player " + player+ " received: " + vote);
    EconomyResponse r = econ.depositPlayer(player.getName(), 1000.0);
     if(r.transactionSuccess()) {
      sender.sendMessage(String.format("Danke fuers Voten!" + "Du hast %s bekommen und hast nun %s", econ.format(r.amount), econ.format(r.balance)));
    return true;
    }
}
