package Farm.wer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.alibaba.fastjson.JSON;

public class Plant {

	private String name;
	private int plantPrice;
	private int harvestPrice;
	private long maturationTime;

	public Plant(String name, int plantPrice, int harvestPrice, long maturationTime) {
		this.name = name;
		this.plantPrice = plantPrice;
		this.harvestPrice = harvestPrice;
		this.maturationTime = maturationTime;
	}

	Plant() {

	}

	public Plant getPlant(String path) {
		String json = "";
		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			String str;
			while ((str = reader.readLine()) != null) {
				json += str;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return JSON.parseObject(json, Plant.class);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPlantPrice() {
		return plantPrice;
	}

	public void setPlantPrice(int plantPrice) {
		this.plantPrice = plantPrice;
	}

	public int getHarvestPrice() {
		return harvestPrice;
	}

	public void setHarvestPrice(int harvestPrice) {
		this.harvestPrice = harvestPrice;
	}

	public long getMaturationTime() {
		return maturationTime;
	}

	public void setMaturationTime(long maturationTime) {
		this.maturationTime = maturationTime;
	}
	
	

}
