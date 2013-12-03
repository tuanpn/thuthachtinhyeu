package vn.sunnet.lovechallenge;

import vn.sunnet.lovechallenge.utils.AnimationCompositeSprite;
import vn.sunnet.lovechallenge.utils.AnimationSprite;
import vn.sunnet.lovechallenge.utils.CompositeSprite;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Resources {

	private static Resources instance;

	public static Resources getInstance() {
		if (instance == null) {
			instance = new Resources();
		}
		return instance;
	}

	public Resources() {

	}

	public void loadGameScreen(AssetManager manager1, AssetManager manager2) {
		manager1.load("bg/sky-1.png", Texture.class);
		manager1.load("bg/sky-2.png", Texture.class);
		manager1.load("bg/sky-3.png", Texture.class);
		manager1.load("bg/sky-4.png", Texture.class);
		manager1.load("bg/sky-5.png", Texture.class);
		manager1.load("bg/sky-6.png", Texture.class);
		manager1.load("bg/road.png", Texture.class);
		manager1.load("bg/house.atlas", TextureAtlas.class);
		manager1.load("bg/bghouse.png", Texture.class);

		manager1.load("player/player.atlas", TextureAtlas.class);

		manager1.load("staticobject/staticobjects.atlas", TextureAtlas.class);
	}

	public void unloadGameScreen(AssetManager manager1, AssetManager manager2) {
		manager1.unload("bg/sky-1.png");
		manager1.unload("bg/sky-2.png");
		manager1.unload("bg/sky-3.png");
		manager1.unload("bg/sky-4.png");
		manager1.unload("bg/sky-5.png");
		manager1.unload("bg/sky-6.png");
		manager1.unload("bg/road.png");
		manager1.unload("bg/house.atlas");
		manager1.unload("bg/bghouse.png");
		manager1.unload("player/player.atlas");
		manager1.unload("staticobject/staticobjects.atlas");
	}

	public TextureRegion sky1Region;
	public TextureRegion sky2Region;
	public TextureRegion sky3Region;
	public TextureRegion sky4Region;
	public TextureRegion sky5Region;
	public TextureRegion sky6Region;
	public TextureRegion roadRegion;
	public TextureRegion house1Region;
	public TextureRegion house2Region;
	public TextureRegion house3Region;
	public TextureRegion house4Region;
	public TextureRegion house5Region;
	public TextureRegion house6Region;
	public TextureRegion house7Region;
	public Sprite wall1Sprite;
	public Sprite wall2Sprite;
	public TextureRegion bghouseRegion;

	public AnimationCompositeSprite player_run_normal;
	public AnimationCompositeSprite player_run_cry;
	public AnimationCompositeSprite player_run_scare;
	public AnimationCompositeSprite player_jump_1;
	public AnimationCompositeSprite player_jump_2;
	public AnimationCompositeSprite player_sit;
	public AnimationCompositeSprite player_die_1;
	public AnimationCompositeSprite player_die_2;

	public TextureRegion car1Region;
	public TextureRegion car2Region;
	public TextureRegion box1Region;
	public TextureRegion box2Region;
	public TextureRegion static1Region;
	public TextureRegion static2Region;
	public TextureRegion static3Region;
	public TextureRegion static4Region;
	public TextureRegion carlong1Region;
	public TextureRegion carlong2Region;
	public TextureRegion carlong3Region;
	public TextureRegion carlong4Region;

	public void getGameScreen(AssetManager manager1, AssetManager manager2) {
		// ============sky=================
		Texture sky1Texture = manager1.get("bg/sky-1.png");
		sky1Texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		sky1Region = new TextureRegion(sky1Texture);

		Texture sky2Texture = manager1.get("bg/sky-2.png");
		sky2Texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		sky2Region = new TextureRegion(sky2Texture);

		Texture sky3Texture = manager1.get("bg/sky-3.png");
		sky3Texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		sky3Region = new TextureRegion(sky3Texture);

		Texture sky4Texture = manager1.get("bg/sky-4.png");
		sky4Texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		sky4Region = new TextureRegion(sky4Texture);

		Texture sky5Texture = manager1.get("bg/sky-5.png");
		sky5Texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		sky5Region = new TextureRegion(sky5Texture);
		// ===========road================
		Texture roadTexture = manager1.get("bg/road.png");
		roadTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		roadRegion = new TextureRegion(roadTexture);
		// ===========house=================
		TextureAtlas houseAtlas = manager1.get("bg/house.atlas");
		house1Region = houseAtlas.findRegion("house1");
		house2Region = houseAtlas.findRegion("house2");
		house3Region = houseAtlas.findRegion("house3");
		house4Region = houseAtlas.findRegion("house4");
		house5Region = houseAtlas.findRegion("house5");
		house6Region = houseAtlas.findRegion("house6");
		house7Region = houseAtlas.findRegion("house7");

		wall1Sprite = houseAtlas.createSprite("wall");
		wall2Sprite = houseAtlas.createSprite("wall-2");

		// ==========housebg=================
		Texture bghouseTexture = manager1.get("bg/bghouse.png");
		bghouseTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		bghouseRegion = new TextureRegion(bghouseTexture);

		TextureAtlas playerAtlas = manager1.get("player/player.atlas");
		// run
		Array<CompositeSprite> player_runFrames = getArrayCompositeSprite(12,
				"run-1", "run-normal", playerAtlas);
		player_run_normal = new AnimationCompositeSprite(
				0.8f / player_runFrames.size, player_runFrames);
		player_run_normal.setPlayMode(AnimationSprite.LOOP);

		Array<CompositeSprite> player_run_cry_Frames = getArrayCompositeSprite(
				12, "run-1", "run-cry", playerAtlas);
		player_run_cry = new AnimationCompositeSprite(
				0.8f / player_run_cry_Frames.size, player_run_cry_Frames);
		player_run_cry.setPlayMode(AnimationSprite.LOOP);

		Array<CompositeSprite> player_run_scare_Frames = getArrayCompositeSprite(
				12, "run-1", "run-scare", playerAtlas);
		player_run_scare = new AnimationCompositeSprite(
				0.8f / player_run_scare_Frames.size, player_run_scare_Frames);
		player_run_scare.setPlayMode(AnimationSprite.LOOP);
		// jump1
		Array<CompositeSprite> player_jump_1_frames = getArrayCompositeSprite(
				11, "jump-1", "jump-1", playerAtlas);
		player_jump_1 = new AnimationCompositeSprite(
				1f / player_jump_1_frames.size, player_jump_1_frames);
		player_jump_1.setPlayMode(AnimationCompositeSprite.NORMAL);
		// jump2
		Array<CompositeSprite> player_jump_2_frames = getArrayCompositeSprite(
				15, "jump-2", "jump-2", playerAtlas);
		player_jump_2 = new AnimationCompositeSprite(
				1f / player_jump_2_frames.size, player_jump_2_frames);
		player_jump_2.setPlayMode(AnimationCompositeSprite.NORMAL);
		// sit
		Array<CompositeSprite> player_sit_frames = getArrayCompositeSprite(13,
				"down", "down", playerAtlas);
		player_sit = new AnimationCompositeSprite(1f / player_sit_frames.size,
				player_sit_frames);
		player_sit.setPlayMode(AnimationCompositeSprite.NORMAL);
		// die 1
		Array<CompositeSprite> player_die_1_frames = getArrayCompositeSprite(
				10, "die-1", "die-1", playerAtlas);
		player_die_1 = new AnimationCompositeSprite(
				1f / player_die_1_frames.size, player_die_1_frames);
		player_die_1.setPlayMode(AnimationCompositeSprite.NORMAL);
		// die 2
		Array<CompositeSprite> player_die_2_frames = getArrayCompositeSprite(
				11, "die-2", "die-2", playerAtlas);
		player_die_2 = new AnimationCompositeSprite(
				1f / player_die_2_frames.size, player_die_2_frames);
		player_die_2.setPlayMode(AnimationCompositeSprite.NORMAL);

		// static
		TextureAtlas staticObjects = manager1
				.get("staticobject/staticobjects.atlas");
		car1Region = staticObjects.findRegion("o-to");
		car2Region = staticObjects.findRegion("o-to-2");
		box1Region = staticObjects.findRegion("box-1");
		box2Region = staticObjects.findRegion("box-2");
		static1Region = staticObjects.findRegion("vc-1");
		static2Region = staticObjects.findRegion("vc-2");
		static3Region = staticObjects.findRegion("vc-4");
		static4Region = staticObjects.findRegion("vc-5");
		carlong1Region = staticObjects.findRegion("car-1");
		carlong2Region = staticObjects.findRegion("car-2");
		carlong3Region = staticObjects.findRegion("car-3");
		carlong4Region = staticObjects.findRegion("car-4");
	}

	public Array<CompositeSprite> getArrayCompositeSprite(int lengFrame,
			String nameBody, String nameHeadState, TextureAtlas atlas) {

		Array<CompositeSprite> frames = new Array<CompositeSprite>();
		for (int i = 0; i < lengFrame; i++) {
			frames.add(new CompositeSprite());
		}
		for (int i = 0; i < frames.size; i++) {
			int index = i + 1;
			String pathBody = "body/" + nameBody + "-(" + index + ")";
			String pathHead = "head/" + nameHeadState + "-(" + index + ")";
			// System.out.println(pathBody + " " + pathhead);
			Sprite body = atlas.createSprite(pathHead);
			Sprite head = atlas.createSprite(pathBody);
			frames.get(i).addComponentSprite(body);
			frames.get(i).addComponentSprite(head);
		}

		return frames;
	}

}
