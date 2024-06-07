package com.poscodx.guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.poscodx.guestbook.repository.GuestbookLogRepository;
import com.poscodx.guestbook.repository.GuestbookRepository;
import com.poscodx.guestbook.vo.GuestBookVo;

@Service
public class GuestbookService {
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	@Autowired
	private GuestbookRepository guestbookRepository;
	
	@Autowired
	private GuestbookLogRepository guestbookLogRepository;
	
	// 리스트 보기 
	public List<GuestBookVo> getContentsList(){
		return guestbookRepository.findAll();
	}
	
	// 글 삭제 
	public void daleteContents(Long no, String password) {

		// Tx: begin
		TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
		
		try {
			
			guestbookLogRepository.update(no);
			guestbookRepository.deleteByNoAndPassword(no, password);
			
			// Tx: end (success)
			transactionManager.commit(status);
		
		} catch(Throwable e){
			// Tx: end (fail)
			transactionManager.rollback(status);
		}
	}
	
	// 글 작성
	public void addContents(GuestBookVo vo) {
		// 트랜잭션 동기 초기화 
		TransactionSynchronizationManager.initSynchronization();   // Thred Local 
		
		Connection conn = DataSourceUtils.getConnection(dataSource);
		
		try {
			// Tx: begin
			conn.setAutoCommit(false);
			
			int count = guestbookLogRepository.update();
			
			if(count==0) {
				guestbookLogRepository.insert();
			}
			
			guestbookRepository.insert(vo);
			
			// Tx: end(success)
			conn.commit();
		} catch(Throwable e) {
			// Tx: end(fail)
			try {
				conn.rollback();
			} catch(SQLException ignore) {
			}
		} finally {
			DataSourceUtils.releaseConnection(conn, dataSource);
		}
		

	}
	
}
