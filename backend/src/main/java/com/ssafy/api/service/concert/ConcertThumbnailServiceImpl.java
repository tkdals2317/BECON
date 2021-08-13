package com.ssafy.api.service.concert;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.swing.filechooser.FileSystemView;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.api.request.ConcertThumbnailPostReq;
import com.ssafy.api.request.UserProfilePostReq;
import com.ssafy.common.util.MD5Generator;
import com.ssafy.db.entity.ConcertThumbnail;
import com.ssafy.db.repository.ConcertThumbnailRepository;

@Service("concertThumbnailService")
public class ConcertThumbnailServiceImpl implements ConcertThumbnailService {
	@Autowired
	ConcertThumbnailRepository concertThumbnailRepository;

	@Transactional
	@Override
	public ConcertThumbnail saveFile(ConcertThumbnailPostReq request) {
		return concertThumbnailRepository.save(request.toEntity());
	}

	@Override
	public ConcertThumbnailPostReq setFile(MultipartFile files)
			throws UnsupportedEncodingException, NoSuchAlgorithmException,
			IllegalStateException, IOException {
		ConcertThumbnailPostReq concertTumbnailInfo = null;
		String origFilename = files.getOriginalFilename();
		String filename = new MD5Generator(origFilename).toString();
		
		String savePath = "/images/thumbnail";
		
		String filePath = savePath + "/" + origFilename;
		files.transferTo(new File(filePath));
		
		concertTumbnailInfo = new ConcertThumbnailPostReq();
		concertTumbnailInfo.setOriginName(origFilename);  
		concertTumbnailInfo.setName(filename);
		concertTumbnailInfo.setPath(filePath);

		return concertTumbnailInfo;
	}
	
//	public static void main(String[] args) throws IOException {
//		System.out.println(System.getProperty("user.dir"));
//		System.out.println(System.getProperty("user.home").concat("/S05P12D102/frontend/dist/img"));
//		File file = new File("../frontend/dist/img");
//		System.out.println(file.getCanonicalPath());
//	}
}
