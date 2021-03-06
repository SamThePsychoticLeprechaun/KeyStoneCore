package com.github.samthepsychoticleprechaun.KeyStoneCore.CommandHandler.Commands;

import org.bukkit.command.CommandSender;
import com.github.samthepsychoticleprechaun.KeyStoneChatGuard.YAML.LoadChatGuardYaml;
import com.github.samthepsychoticleprechaun.KeyStoneChat.API.Chat.SendMessage;
import com.github.samthepsychoticleprechaun.KeyStoneChat.YAML.LoadChatYaml;
import com.github.samthepsychoticleprechaun.KeyStoneCore.KeyStoneCore;
import com.github.samthepsychoticleprechaun.KeyStoneCore.API.General.IsEnabled;
import com.github.samthepsychoticleprechaun.KeyStoneCore.Storage.StringValues;
import com.github.samthepsychoticleprechaun.KeyStoneCore.YAML.LoadYaml;

public class Reload {
	
	public Reload() {
		return;
	}
	
	KeyStoneCore plugin = KeyStoneCore.plugin;
	IsEnabled isEnabled = new IsEnabled();
	SendMessage msg = null;
	
	StringValues load = new StringValues();
	String allReloadSuccess = load.getReloadallsuccess();
	String coreReloadSuccess = load.getReloadcoresuccess();
	String chatReloadSuccess = load.getReloadchatsuccess();
	String chatGuardReloadSuccess = load.getReloadchatguardsuccess();
	
	/**
	 * Reload all configuration files from disk to memory.
	 * 
	 * Sends a message to Command Sender on success.
	 * 
	 * @param sender - Command Sender
	 * @return Boolean of true if successful, else returns false.
	 */
	public boolean reload(CommandSender sender) {
		
		if (isEnabled.getIsEnabledList().get("KeyStoneChat")) {
			msg = new SendMessage();
		}
		
		if (!rldCore())
			return false;
		if (!rldChat())
			return false;
		if (!rldChatGuard())
			return false;
		
		if (isEnabled.getIsEnabledList().get("KeyStoneChat")) {

			msg.sendMessage(allReloadSuccess, sender);			
			
		} else {
			
			sender.sendMessage(allReloadSuccess);
			
		}
		
		return true;
		
	}
	
	/**
	 * Reload all configuration files from disk to memory.
	 * 
	 * @return Boolean of true if successful, else returns false.
	 */
	public boolean reload() {
		
		if (!rldCore())
			return false;
		if (!rldChat())
			return false;
		if (!rldChatGuard())
			return false;
		
		return true;
		
	}
	
	/**
	 * Reload Core configuration files from disk to memory.
	 * 
	 * Sends a message to Command Sender on success.
	 * 
	 * @param sender - Command Sender
	 * @return Boolean of true if successful, else returns false.
	 */
	public boolean reloadCore(CommandSender sender) {
		
		if (isEnabled.getIsEnabledList().get("KeyStoneChat")) {
			msg = new SendMessage();
		}
		
		if (!rldCore())
			return false;
		
		if (isEnabled.getIsEnabledList().get("KeyStoneChat")) {
			
			msg.sendMessage(coreReloadSuccess, sender);
			
		} else {
			
			sender.sendMessage(coreReloadSuccess);
			
		}
		
		return true;
		
	}
	
	/**
	 * Reload Core configuration files from disk to memory.
	 * 
	 * @return Boolean of true if successful, else returns false.
	 */
	public boolean reloadCore() {
		
		if (!reloadCore())
			return false;
		
		return true;
		
	}
	
	/**
	 * Reload Chat configuration files from disk to memory.
	 * 
	 * Sends a message to Command Sender on success.
	 * 
	 * @param sender - Command Sender
	 * @return Boolean of true if successful, else returns false.
	 */
	public boolean reloadChat(CommandSender sender) {
		
		if (isEnabled.getIsEnabledList().get("KeyStoneChat")) {
			msg = new SendMessage();
		}
		
		if (!rldChat())
			return false;
		
		if (isEnabled.getIsEnabledList().get("KeyStoneChat")) {
			
			msg.sendMessage(chatReloadSuccess, sender);
			
		} else {
			
			sender.sendMessage(chatReloadSuccess);
			
		}
		
		return true;
		
	}
	
	/**
	 * Reload Chat configuration files from disk to memory.
	 * 
	 * @return Boolean of true if successful, else returns false.
	 */
	public boolean reloadChat() {
		
		if (!rldChat())
			return false;
		
		return true;
		
	}
	
	/**
	 * Reload Chat Guard configuration files from disk to memory.
	 * 
	 * Sends a message to Command Sender on success.
	 * 
	 * @param sender - Command Sender
	 * @return Boolean of true if successful, else returns false.
	 */
	public boolean reloadChatGuard(CommandSender sender) {
		
		if (isEnabled.getIsEnabledList().get("KeyStoneChat")) {
			msg = new SendMessage();
		}
		
		if (!rldChatGuard())
			return false;
		
		if (isEnabled.getIsEnabledList().get("KeyStoneChat")) {
			
			msg.sendMessage(chatGuardReloadSuccess, sender);
			
		} else {
			
			sender.sendMessage(chatGuardReloadSuccess);
			
		}
		
		return true;
		
	}
	
	/**
	 * Reload Chat Guard configuration files from disk to memory.
	 * 
	 * @return Boolean of true if successful, else returns false.
	 */
	public boolean reloadChatGuard() {
		
		if (!rldChatGuard())
			return false;
		
		return true;
		
	}
	
	private boolean rldCore() {
		
		LoadYaml load = new LoadYaml();
		
		if (!load.loadYamls())
			return false;
		
		return true;
		
	}
	
	private boolean rldChat() {
		
		LoadChatYaml load = new LoadChatYaml();
			
			if (!load.loadYamls())
				return false;
		
		return true;
		
	}
	
	private boolean rldChatGuard() {
		
		LoadChatGuardYaml load = new LoadChatGuardYaml();
		
		if (!load.loadYamls())
			return false;
		
		return true;
		
	}

}
