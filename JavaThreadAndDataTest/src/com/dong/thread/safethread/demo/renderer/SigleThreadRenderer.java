package com.dong.thread.safethread.demo.renderer;

import java.util.ArrayList;
import java.util.List;

import com.dong.thread.safethread.bean.ImageData;

/**
 * 单线程页面渲染器
 * @author dong
 *	页面渲染器：渲染文本且预留图片的尺寸集中下载图片下载完成后再去替代图片
 */
public class SigleThreadRenderer {
	
	public static void main(String[] args) {
		renderText();
		List<ImageData> list = new ArrayList<>();
		String source = args.toString();//获取图片的信息
		ImageData imageData = scanImageData(source);
		list.add(imageData);
		for (ImageData imageData2 : list) {
			//下载图片
			renderImage(imageData2);
		}
	}

	private static void renderImage(ImageData imageData2) {
		
	}

	private static ImageData scanImageData(String source) {
		return null;
	}

	private static void renderText() {
		
	}

}
