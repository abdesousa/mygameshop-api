package com.mygameshop;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.mygameshop.api.persistence.repository.ProductRepository;
import com.mygameshop.api.service.ProductService;
import com.mygameshop.api.service.impl.ProductServiceImpl;

@SpringBootTest
class MyGameShopApplicationTests {

	 	private final ProductRepository repository;
	    private final ProductService service;

	    public MyGameShopApplicationTests() {

	        this.repository = Mockito.mock(ProductRepository.class);
	        this.service = new ProductServiceImpl(repository);

	    }
	    @Test
	    public void givenNoValueThenReturnAllBitmaps() throws SQLSystemException {

	        List<ICSBitmapNewBean> beans = new ArrayList<ICSBitmapNewBean>();
	        beans.add(new ICSBitmapNewBean(1, "Test Ics Bitmap 1", "1.0", false));
	        beans.add(new ICSBitmapNewBean(2, "Test Ics Bitmap 2", "1.1", false));

	        Mockito.when(repository.getBitMaps()).thenReturn(beans);

	        List<WebIcsBitmap> webBeans = this.service.getBitMaps();

	        Assert.assertEquals(Integer.valueOf(1), webBeans.get(0).getId());
	        Assert.assertEquals("Test Ics Bitmap 1", webBeans.get(0).getName());
	    }

	
	@Test
	void given_ValidId_When_() {
		
		
	}

}
