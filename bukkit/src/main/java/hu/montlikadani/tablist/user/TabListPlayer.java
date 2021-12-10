package hu.montlikadani.tablist.user;

import hu.montlikadani.tablist.TabList;
import hu.montlikadani.tablist.tablist.TabHandler;
import hu.montlikadani.tablist.tablist.groups.GroupPlayer;
import hu.montlikadani.tablist.tablist.playerlist.HidePlayers;
import hu.montlikadani.tablist.tablist.playerlist.PlayerList;

import java.util.UUID;

import org.bukkit.entity.Player;

public class TabListPlayer implements TabListUser {

	private final TabList plugin;
	private final UUID uniqueId;

	private final GroupPlayer groupPlayer;
	private final TabHandler tabHandler;

	private HidePlayers hidePlayers;
	private PlayerList playerList;

	public TabListPlayer(TabList plugin, UUID uniqueId) {
		this.plugin = plugin;
		this.uniqueId = uniqueId;

		tabHandler = new TabHandler(plugin, this);
		groupPlayer = new GroupPlayer(plugin, this);
	}

	@Override
	public Player getPlayer() {
		return plugin.getServer().getPlayer(uniqueId);
	}

	@Override
	public UUID getUniqueId() {
		return uniqueId;
	}

	@Override
	public GroupPlayer getGroupPlayer() {
		return groupPlayer;
	}

	@Override
	public TabHandler getTabHandler() {
		return tabHandler;
	}

	@Override
	public boolean isHidden() {
		return playerList != null;
	}

	@Override
	public void setHidden(boolean hidden) {
		if (hidden) {
			if (playerList == null) {
				playerList = new PlayerList(plugin, this);
			}

			playerList.hide();
		} else if (playerList != null) {
			playerList.showEveryone();
			playerList = null;
		}
	}

	@Override
	public boolean isRemovedFromPlayerList() {
		return hidePlayers != null;
	}

	@Override
	public void removeFromPlayerList() {
		if (hidePlayers == null) {
			hidePlayers = new HidePlayers(plugin, uniqueId);
			hidePlayers.removePlayerFromTab();
		}
	}

	@Override
	public void addToPlayerList() {
		if (hidePlayers != null) {
			hidePlayers.addPlayerToTab();
			hidePlayers = null;
		}
	}

	@Override
	public boolean equals(Object o) {
		return o != null && o.getClass() == getClass() && uniqueId.equals(((TabListPlayer) o).uniqueId);
	}

	public HidePlayers getHidePlayers() {
		return hidePlayers;
	}

	public PlayerList getPlayerList() {
		return playerList;
	}
}