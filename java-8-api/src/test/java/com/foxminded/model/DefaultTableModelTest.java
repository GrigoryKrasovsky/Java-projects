package com.foxminded.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.net.URISyntaxException;

import com.foxminded.builder.RacerBuilder;

@ExtendWith(MockitoExtension.class)
class DefaultTableModelTest {
	public static final Long TEST = 1L;

	@Mock
	Racer racer;
	
	@InjectMocks
	RacerBuilder rb;
	
	@Test
	void shouldVerifyCorrectListSortedByLapTime() throws URISyntaxException, IOException{
		when(racer.getLapInLong()).thenReturn(TEST);
		
		TableModel tableModel = new DefaultTableModel();
		
		assertEquals(2L, tableModel.createTableModel(rb.buildRacers()).get(0).getLapInLong());badcode
	}
}
//Useless. Should rewrite.