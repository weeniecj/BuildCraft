package buildcraft.factory;

import java.util.ArrayList;

import buildcraft.api.tools.IToolWrench;
import buildcraft.core.CreativeTabBuildCraft;
import buildcraft.core.utils.Utils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockLeacher extends BlockContainer {

	private Icon textureTop;
	private Icon textureBottom;
	private Icon textureSide;

	public BlockLeacher(int i) {
		super(i, Material.iron);
		setHardness(5F);
		setCreativeTab(CreativeTabBuildCraft.tabBuildCraft);
	}

	@Override
	public TileEntity createNewTileEntity(World var1) {
		return new TileLeacher();
	}

	@Override
	public Icon getIcon(int i, int j) {
		switch (i) {
			case 0:
				return textureBottom;
			case 1:
				return textureTop;
			default:
				return textureSide;
		}
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, int par5, int par6) {
		Utils.preDestroyBlock(world, x, y, z);
		super.breakBlock(world, x, y, z, par5, par6);
	}

	/*@Override
	public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entityplayer, int par6, float par7, float par8, float par9) {
		TileEntity tile = world.getBlockTileEntity(i, j, k);

		if (tile instanceof TilePump) {
			TilePump pump = (TilePump) tile;

			// Drop through if the player is sneaking
			if (entityplayer.isSneaking())
				return false;

			// Restart the quarry if its a wrench
			Item equipped = entityplayer.getCurrentEquippedItem() != null ? entityplayer.getCurrentEquippedItem().getItem() : null;
			if (equipped instanceof IToolWrench && ((IToolWrench) equipped).canWrench(entityplayer, i, j, k)) {

				pump.tank.reset();
				pump.rebuildQueue();
				((IToolWrench) equipped).wrenchUsed(entityplayer, i, j, k);
				return true;
			}
		}

		return false;
	}*/

	@SuppressWarnings({"unchecked", "rawtypes"})
	@Override
	public void addCreativeItems(ArrayList itemList) {
		itemList.add(new ItemStack(this));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		textureTop = par1IconRegister.registerIcon("buildcraft:leacher_top");
		textureBottom = par1IconRegister.registerIcon("buildcraft:leacher_bottom");
		textureSide = par1IconRegister.registerIcon("buildcraft:leacher_side");
	}

}
