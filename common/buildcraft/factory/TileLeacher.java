package buildcraft.factory;

import net.minecraftforge.common.ForgeDirection;
import buildcraft.api.gates.IAction;
import buildcraft.api.power.IPowerReceptor;
import buildcraft.api.power.PowerHandler;
import buildcraft.api.power.PowerHandler.PowerReceiver;
import buildcraft.core.IMachine;
import buildcraft.core.TileBuildCraft;

public class TileLeacher extends TileBuildCraft implements IMachine, IPowerReceptor{
	
	public TileLeacher() {}

	@Override
	public PowerReceiver getPowerReceiver(ForgeDirection side) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void doWork(PowerHandler workProvider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isActive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean manageFluids() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean manageSolids() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean allowAction(IAction action) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
