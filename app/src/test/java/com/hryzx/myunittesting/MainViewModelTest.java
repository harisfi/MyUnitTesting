package com.hryzx.myunittesting;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MainViewModelTest {

    private MainViewModel mainViewModel;
    private CuboidModel cuboidModel;

    private final double dummyWidth = 7, dummyLength = 12, dummyHeight = 6,
            dummyVolume = 504, dummyCircumfence = 100, dummySurfaceArea = 396;

    @Before
    public void before() {
        cuboidModel = mock(CuboidModel.class);
        mainViewModel = new MainViewModel(cuboidModel);
    }

    @Test
    public void testVolume() {
        cuboidModel = new CuboidModel();
        mainViewModel = new MainViewModel(cuboidModel);
        mainViewModel.save(dummyLength, dummyWidth, dummyHeight);
        double volume = mainViewModel.getVolume();
        assertEquals(dummyVolume, volume, 0.0001);
    }

    @Test
    public void testCircumfence() {
        cuboidModel = new CuboidModel();
        mainViewModel = new MainViewModel(cuboidModel);
        mainViewModel.save(dummyLength, dummyWidth, dummyHeight);
        double circumfence = mainViewModel.getCircumfence();
        assertEquals(dummyCircumfence, circumfence, 0.0001);
    }

    @Test
    public void testSurfaceArea() {
        cuboidModel = new CuboidModel();
        mainViewModel = new MainViewModel(cuboidModel);
        mainViewModel.save(dummyLength, dummyWidth, dummyHeight);
        double surfaceArea = mainViewModel.getSurfaceArea();
        assertEquals(dummySurfaceArea, surfaceArea, 0.0001);
    }

    @Test
    public void testMockVolume() {
        when(mainViewModel.getVolume()).thenReturn(dummyVolume);
        double volume = mainViewModel.getVolume();
        verify(cuboidModel).getVolume();
        assertEquals(dummyVolume, volume, 0.0001);
    }

    @Test
    public void testMockCircumfence() {
        when(mainViewModel.getCircumfence()).thenReturn(dummyCircumfence);
        double circumfence = mainViewModel.getCircumfence();
        verify(cuboidModel).getCircumfence();
        assertEquals(dummyCircumfence, circumfence, 0.0001);
    }

    @Test
    public void testMockSurfaceArea() {
        when(mainViewModel.getSurfaceArea()).thenReturn(dummySurfaceArea);
        double surfaceArea = mainViewModel.getSurfaceArea();
        verify(cuboidModel).getSurfaceArea();
        assertEquals(dummySurfaceArea, surfaceArea, 0.0001);
    }

    @Test
    public void save() {
    }

    @Test
    public void getCircumfence() {
    }

    @Test
    public void getSurfaceArea() {
    }

    @Test
    public void getVolume() {
    }
}