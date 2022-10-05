package ru.tversu.apka;

import com.jlefebure.spring.boot.minio.MinioService;
import io.minio.MinioClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@ActiveProfiles(profiles = {"test"})
public class ApkaApplicationTests {

  @MockBean
  MinioClient minioClient;

  @InjectMocks
  MinioService minioService;

  @Test
  void contextLoads() {
  }

}
