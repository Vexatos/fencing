package nl.tyrope.fencing.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import nl.tyrope.fencing.Refs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FenceBlockItem extends ItemBlock {

	public static Icon[] FenceItemIcons;

	public FenceBlockItem(int id) {
		super(id);
		setHasSubtypes(true);
		setUnlocalizedName("fenceBlock");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		FenceItemIcons = new Icon[4];
		for (int i = 0; i < 4; i++) {
			FenceItemIcons[i] = icon.registerIcon(Refs.MODID
					+ ":iconFence" + Refs.subNames[i]);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(ItemStack i, int j) {
		return FenceItemIcons[i.getItemDamage()];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int dmg) {
		return FenceItemIcons[dmg];
	}

	@Override
	public int getMetadata(int damageValue) {
		return damageValue;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		return getUnlocalizedName() + Refs.subNames[itemstack.getItemDamage()];
	}
}