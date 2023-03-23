package com.example.capstone.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.example.capstone.entity.LogEntity;
import com.example.capstone.repository.LogRepository;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class LogServiceTest {

    private LogService logService;

    @Mock
    private LogRepository logRepositoryMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        logService = new LogService(logRepositoryMock);
    }

    @Test
    void shouldReturnLogsForDevice() {
        int deviceId = 123;
        LogEntity log1 = new LogEntity(123,32,16,700);
        LogEntity log2 = new LogEntity(123,22,16,750);
        ArrayList<LogEntity> expectedLogs = new ArrayList<>();
        expectedLogs.add(log1);
        expectedLogs.add(log2);
        when(logRepositoryMock.findAllById(123)).thenReturn(expectedLogs);

        ArrayList<LogEntity> actualLogs = logService.ans(deviceId);

        assertThat(actualLogs).isEqualTo(expectedLogs);
        System.out.println(actualLogs.get(0).toString());
    }
}