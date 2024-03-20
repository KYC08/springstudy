package com.gdu.prj06;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gdu.prj06.dao.ContactDao;
import com.gdu.prj06.dto.ContactDto;
import com.gdu.prj06.service.ContactService;

/* 1. JUnit4 를 이용한다. */
@RunWith(SpringJUnit4ClassRunner.class)

//ContactService 타입의 ContactServiceImpl bean 이 등록된 파일
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})


public class ContactTxTest {
  
  @Autowired
  private ContactService contactService;
  
  @Test
  public void 트랜잭션_테스트() {
    contactService.txTest();
  }
  
  private ContactDao contactDao;
  
  @Autowired
  public void setContactDao(ContactDao contactDao) {
    this.contactDao = contactDao;
  }

  @Test
  public void test01_등록() {
    
    ContactDto contact = ContactDto.builder()
                            .name("테스트이름")
                            .mobile("테스트모바일")
                            .email("테스트이메일")
                            .address("테스트주소")
                          .build();
    int insertCount = contactDao.registerContact(contact);
    assertEquals(1, insertCount);
    
  }
  
  @Test
  public void test02_조회() {
    
    int contactNo = 1;
    
    ContactDto contact = contactDao.getContactByNo(contactNo);
    
    assertNotNull(contact);
    
  }
  
  @Test
  public void test03_수정() {
    
    ContactDto contact = ContactDto.builder()
                            .name("[수정]테스트이름")
                            .mobile("[수정]모바일")
                            .email("[수정]테스트이메일")
                            .address("[수정]테스트주소")
                            .contactNo(1)
                          .build();
    
    int updateCount = contactDao.modifyContact(contact);
    
    assertEquals(1, updateCount);
    
  }
  
  @Test
  public void test04_목록() {
    
    List<ContactDto> contactList = contactDao.getContactList();
    
    assertEquals(1, contactList.size());
    
  }
  
  @Test
  public void test05_삭제() {
    
    int contactNo = 1;
    
    int deleteCount = contactDao.removeContact(contactNo);
    
    assertEquals(1, deleteCount);
    
  }
  
}
