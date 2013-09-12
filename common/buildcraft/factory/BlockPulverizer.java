package buildcraft.factory;

import java.util.ArrayList;

import buildcraft.core.CreativeTabBuildCraft;
import buildcraft.core.utils.Utils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockPulverizer extends BlockContainer {

	private Icon textureTopBottom;
	private Icon textureFrontBack;
	private Icon textureSide;

	public BlockPulverizer(int i) {
		super(i, Material.iron);
		setHardness(5F);
		setCreativeTab(CreativeTabBuildCraft.tabBuildCraft);
	}

	@Override
	public TileEntity createNewTileEntity(World var1) {
		return new TilePulverizer();
	}

	@Override
	public Icon getIcon(int i, int j) {
		
		// If no metadata is set, then this is an icon.
		if (j == 0 && i == 3)
			return textureFrontBack;

		if (i == j && i>1) // Front can't be top or bottom.
			return textureFrontBack;

		switch (i) {
		case 1:
			return textureTopBottom;
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
		textureTopBottom = par1IconRegister.registerIcon("buildcraft:pulverizer_top_bottom");
		textureFrontBack = par1IconRegister.registerIcon("buildcraft:pulverizer_front_back");
		textureSide = par1IconRegister.registerIcon("buildcraft:pulverizer_side");
	}

}
