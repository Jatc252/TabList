package hu.montlikadani.tablist.bukkit.tablist.fakeplayers;

import java.util.UUID;

import org.bukkit.entity.Player;

/**
 * The interface for creating fake players
 */
public interface IFakePlayers {

	/**
	 * Gets the fake player name.
	 * <p>
	 * This should <b>not be confused</b> with display name!
	 * 
	 * @return the name of the fake player
	 */
	String getName();

	/**
	 * Sets the name of this fake player.
	 * 
	 * @param name the new name
	 */
	void setName(String name);

	/**
	 * Gets the display name of the fake player.
	 * 
	 * @return display name of fake player
	 */
	String getDisplayName();

	/**
	 * Sets the display name of the fake player.
	 * 
	 * @param displayName the new name
	 */
	void setDisplayName(String displayName);

	/**
	 * Gets the fake player ping current set of latency.
	 * 
	 * @return the amount of latency
	 */
	int getPingLatency();

	/**
	 * Attempts to create a fake player for the given player, setting their head
	 * skin from uuid and ping.
	 * 
	 * @param player      {@link Player} where to display
	 * @param headId      an uuid of valid user
	 * @param pingLatency ping value (> 0)
	 */
	void createFakePlayer(Player player, String headId, int pingLatency);

	/**
	 * Attempts to set the fake player ping to a new one. If the fake player is not
	 * added before, returns.
	 * 
	 * @param pingAmount ping value (> 0)
	 */
	void setPing(int pingAmount);

	/**
	 * Attempts to set the valid user skin uuid to player list for fake player
	 * before their name.
	 * 
	 * @param skinId an valid user skin uuid
	 */
	void setSkin(UUID skinId);

	/**
	 * Attempts to remove an added fake player.
	 */
	void removeFakePlayer();

}