package dev.nonamecrackers2.simpleclouds.common.data;

import org.apache.commons.lang3.StringUtils;

import dev.nonamecrackers2.simpleclouds.SimpleCloudsMod;
import dev.nonamecrackers2.simpleclouds.common.config.SimpleCloudsConfig;
import dev.nonamecrackers2.simpleclouds.common.noise.AbstractNoiseSettings;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fml.ModList;
import nonamecrackers2.crackerslib.common.util.data.ConfigLangGeneratorHelper;

public class SimpleCloudsLangProvider extends LanguageProvider
{
	public SimpleCloudsLangProvider(PackOutput output)
	{
		super(output, SimpleCloudsMod.MODID, "en_us");
	}
	
	@Override
	protected void addTranslations()
	{
		ConfigLangGeneratorHelper.langForSpec(SimpleCloudsMod.MODID, SimpleCloudsConfig.CLIENT_SPEC, this, ConfigLangGeneratorHelper.Info.ONLY_RANGE);
		this.add("gui.simpleclouds.cloud_previewer.title", "Cloud Previewer");
		this.add("gui.simpleclouds.cloud_previewer.button.title", "Cloud Previewer");
		this.add("gui.simpleclouds.cloud_previewer.button.add_layer.title", "Add Layer");
		this.add("gui.simpleclouds.cloud_previewer.button.remove_layer.title", "Remove Layer");
		this.add("gui.simpleclouds.cloud_previewer.button.toggle_preview.title", "Toggle Preview");
		this.add("gui.simpleclouds.cloud_previewer.current_layer", "Current Layer: %s");
		this.add("simpleclouds.key.openGenPreviewer", "Open Cloud Gen Previewer");
		this.add("simpleclouds.key.categories.main", ModList.get().getModContainerById(SimpleCloudsMod.MODID).get().getModInfo().getDisplayName());
		for (AbstractNoiseSettings.Param parameter : AbstractNoiseSettings.Param.values())
		{
			String key = "gui.simpleclouds.noise_settings.param." + parameter.toString().toLowerCase() + ".name";
			String[] splitted = parameter.toString().toLowerCase().split("_");
			for (int i = 0; i < splitted.length; i++)
				splitted[i] = StringUtils.capitalize(splitted[i]);
			this.add(key, StringUtils.join(splitted, " "));
		}
		this.add("simpleclouds.config.preset.optimal_mesh", "Optimal Mesh");
		this.add("simpleclouds.config.preset.optimal_mesh.description", "A more complete cloud mesh that fairs better with storm fog. Removes the small delay for chunks to appear that can be seen when using frustum culling, however at the cost of more vertices. Clouds may appear to move with a slight stutter when moving fast.");
		this.add("simpleclouds.config.preset.fast_culled_mesh", "Fast Culled Mesh");
		this.add("simpleclouds.config.preset.fast_culled_mesh.description", "Heavily lowers the total vertex count by applying culling. Generates the cloud mesh much faster. A small delay for chunks to appear is present when turning fast.");
		this.add("gui.simpleclouds.noise_settings.param.range", "Range: %s - %s");
		this.add("gui.simpleclouds.cloud_previewer.button.previous_layer.title", "Previous layer");
		this.add("gui.simpleclouds.cloud_previewer.button.next_layer.title", "Next layer");
		this.add("gui.simpleclouds.cloud_previewer.warning.too_many_cubes", "Warning: Too many cubes");
		this.add("gui.simpleclouds.cloud_previewer.storminess.title", "Storminess");
		this.add("gui.simpleclouds.cloud_previewer.storm_start.title", "Storm Start Level");
		this.add("gui.simpleclouds.cloud_previewer.storm_fade_distance.title", "Storm Fade Distance");
		this.add("gui.simpleclouds.cloud_previewer.load.title", "Load");
		this.add("gui.simpleclouds.cloud_previewer.export.title", "Export");
		this.add("gui.simpleclouds.cloud_previewer.popup.select.cloud_type", "Select a cloud type:");
		this.add("gui.simpleclouds.cloud_previewer.popup.export.cloud_type", "What would you like to name your cloud type?");
		this.add("gui.simpleclouds.cloud_previewer.popup.export.exists", "A file with that name already exists. Would you like to override it?");
		this.add("gui.simpleclouds.cloud_previewer.popup.exported.cloud_type", "Your cloud type has been exported to %s");
		this.add("gui.simpleclouds.cloud_previewer.info", "Welcome to the cloud previewer!\n\nAdd, remove, and customize noise layers seen in the left of the screen to create custom cloud types. Use the load button in the bottom right to load existing cloud types to edit them, and use the export button to export your cloud types as JSON files.");
	}
}
