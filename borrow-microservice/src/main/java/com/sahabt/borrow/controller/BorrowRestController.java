package com.sahabt.borrow.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.sahabt.borrow.dto.request.AddBorrowRequest;
import com.sahabt.borrow.dto.response.BorrowResponse;
import com.sahabt.borrow.service.BorrowService;
import com.sahabt.borrow.validation.TcKimlikNo;

@RestController
@RequestMapping("borrows")
@RequestScope
@Validated
@CrossOrigin
public class BorrowRestController {
	
	private final Logger logger = LoggerFactory.getLogger(BorrowRestController.class);

	private BorrowService borrowService;

	public BorrowRestController(BorrowService borrowService) {

		this.borrowService = borrowService;
	}
	
	@PostMapping
	public BorrowResponse addBorrow(@RequestBody @Validated AddBorrowRequest request) {
		return borrowService.addBorrow(request);
	}
	
	@DeleteMapping("{identityNo}")
	public BorrowResponse fireEmployee(
			@PathVariable @TcKimlikNo String identityNo) {
		return borrowService.removeBorrow(identityNo);
	}
	
	@GetMapping("{identityNo}")
	public BorrowResponse getEmployeeInfo(
			@PathVariable @TcKimlikNo String identityNo, HttpServletRequest request) {
		logger.info("Receiving a request from the session {}.",request.getSession().getId());
		return borrowService.getInformationBorrow(identityNo);
	}
	
	
	@GetMapping()
	public ResponseEntity<List<BorrowResponse>> getAllBorrows() {
		return ResponseEntity.ok(
				borrowService.getAllBorrow()
		); 
	}
	
//	@GetMapping()
//	public ResponseEntity<List<BorrowResponse>> getAllBorrowByIdentityNo(
//	  @PathVariable @TcKimlikNo String identity) {
//		return ResponseEntity.ok(
//				borrowService.getAllBorrowByIdentityNo(identity)
//		); 
//	}

	

}
