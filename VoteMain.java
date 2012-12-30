import com.vexsoftware.votifier.model.Vote;
import com.vexsoftware.votifier.model.VoteListener;
import net.milkbowl.vault.economy.Economy;
 
public class VoteMain extends javaPlugin implements VoteListener{

public static Economy econ = null;

        @Override
  public void onEnable(){
        setupEconomy();
	system.out.println("der VoteListener ist gestartet!");
	getServer().getPluginManager().registerEvents(new VoteListener(), this);
			      }
        @Override
	public void onDisable(){
	system.out.println("der VoteListener ist gestoppt!)
				}

 private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        		 }
        econ = rsp.getProvider();
        return econ != null;
    }

    public void voteMade(Vote vote) {
    Player player = this.getServer().getPlayer();
    System.out.println("the Player " + player+ " received: " + vote);
    EconomyResponse r = econ.depositPlayer(player.getName(), 1000.0);
     if(r.transactionSuccess()) {
      sender.sendMessage(String.format("Danke fuers Voten!" + "Du hast %s bekommen und hast nun %s", econ.format(r.amount), econ.format(r.balance)));
    return true;
				}
    				     }

					     }
