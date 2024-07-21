package dev.nonamecrackers2.simpleclouds.client.world;

import dev.nonamecrackers2.simpleclouds.common.config.SimpleCloudsConfig;
import dev.nonamecrackers2.simpleclouds.common.world.CloudManager;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.Level;

public class ClientCloudManager extends CloudManager
{
	private boolean receivedSync;
	
	public ClientCloudManager(Level level)
	{
		super(level);
	}

	@Override
	public float getSpeed()
	{
		return this.receivedSync ? super.getSpeed() : SimpleCloudsConfig.CLIENT.speedModifier.get().floatValue();
	}
	
	@Override
	public int getCloudHeight()
	{
		return this.receivedSync ? super.getCloudHeight() : SimpleCloudsConfig.CLIENT.cloudHeight.get();
	}
	
	public void setReceivedSync()
	{
		this.receivedSync = true;
	}
	
	public boolean hasReceivedSync()
	{
		return this.receivedSync;
	}
	
	public static boolean isAvailableServerSide()
	{
		Minecraft mc = Minecraft.getInstance();
		if (mc.level != null)
			return ((ClientCloudManager)CloudManager.get(mc.level)).hasReceivedSync();
		else
			return false;
	}
}
