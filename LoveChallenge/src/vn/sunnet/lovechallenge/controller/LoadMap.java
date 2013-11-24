package vn.sunnet.lovechallenge.controller;

import java.io.IOException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.XmlReader;

public class LoadMap {

	public static int player_position_x;
	public static int player_position_y;
	public static int player_velocity_x;
	public static int player_velocity_y;// jump
	public static int player_gravity_y;// jump
	public static int player_width_jump;
	public static int player_height_jump;
	public static int player_width_run;
	public static int player_height_run;
	public static int player_width_sit;
	public static int player_height_sit;
	public static int player_time_sit;

	public static void loadMapPlayer() {
		try {
			XmlReader.Element xml_element_player = new XmlReader()
					.parse(Gdx.files.internal("maps/1/player.xml"));

			player_position_x = Integer.parseInt(xml_element_player.get("x"));
			player_position_y = Integer.parseInt(xml_element_player.get("y"));
			player_velocity_x = Integer.parseInt(xml_element_player.get("vx"));
			player_velocity_y = Integer.parseInt(xml_element_player.get("vy"));
			player_gravity_y = Integer.parseInt(xml_element_player
					.get("gravity"));

			String player_width_jump_string = xml_element_player.getChildByName(
					"jump").getAttribute("width");
			player_width_jump = Integer.parseInt(player_width_jump_string);
			String player_height_jump_string = xml_element_player
					.getChildByName("jump").getAttribute("height");
			player_height_jump = Integer.parseInt(player_height_jump_string);
			
			String player_width_run_string = xml_element_player.getChildByName(
					"run").getAttribute("width");
			player_width_run = Integer.parseInt(player_width_run_string);
			String player_height_run_string = xml_element_player
					.getChildByName("run").getAttribute("height");
			player_height_run = Integer.parseInt(player_height_run_string);

			String player_width_sit_string = xml_element_player.getChildByName(
					"sit").getAttribute("width");
			player_width_sit = Integer.parseInt(player_width_sit_string);
			String player_height_sit_string = xml_element_player
					.getChildByName("sit").getAttribute("height");
			player_height_sit = Integer.parseInt(player_height_sit_string);
			String player_time_sit_string = xml_element_player.getChildByName(
					"sit").getAttribute("time");
			player_time_sit = Integer.parseInt(player_time_sit_string);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int static_banana_width;
	public static int static_banana_height;
	public static int static_car_width;
	public static int static_car_height;

	public static void loadMapStatic() {
		try {
			XmlReader.Element xml_element_static = new XmlReader()
					.parse(Gdx.files.internal("maps/1/static.xml"));

			String banana_string_width = xml_element_static.getChildByName(
					"banana").getAttribute("width");
			static_banana_width = Integer.parseInt(banana_string_width);
			String banana_string_height = xml_element_static.getChildByName(
					"banana").getAttribute("height");
			static_banana_height = Integer.parseInt(banana_string_height);

			String car_string_width = xml_element_static.getChildByName("car")
					.getAttribute("width");
			static_car_width = Integer.parseInt(car_string_width);
			String car_string_height = xml_element_static.getChildByName("car")
					.getAttribute("height");
			static_car_height = Integer.parseInt(car_string_height);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
