# archisketch
archisketchTest_강기훈
---
**0. 개발환경**
    `InteliJ`
    `Kotlin`
    `Gradle`
    `Mysql`
    `Postman`

    ConURL : `localhost:8082`
---
**1. 단순 Response API 개발**

- **Endpoint**: `/health`
- **Method**: `GET`
- **Request**: None
    - example

      http://localhost:8082/health
- **Response**
    - Type: `String`
    - Field:`1`
---
**2. Open API 조회 개발**
- **Endpoint**: `/cylinder`
- **Method**: `GET`
- **Request**: None
    - example

      http://localhost:8082/cylinder
- **Response**
    - Type: `JSON`
    - Field:
        - `name`, `editorAsset`
      - Example Data
        ```json
        {
          "name":"FLOOR COMPOSITION",
          "editorAsset":
            {
              "twoD":null,
              "threeD":"https://resources.archisketch.com/product/YB0Njg-02923BC5C1A84C59/03-05-2022_05-41-12/3d/YB0Njg-02923BC5C1A84C59.gltf",
              "dxfUrl":null,
              "decimate":"https://resources.archisketch.com/product/YB0Njg-02923BC5C1A84C59/03-05-2022_05-41-12/decimated/YB0Njg-02923BC5C1A84C59_decimated.gltf"
            }
        }
          ```
---    
**3. 조회 API 개발**
- **Endpoint**: `/sigungu`
- **method**: `GET`
- **Request Params**
    - `{pid_loc_code}`: 1111000000 과 같이 특정 시도별로 조회
    - example
  
      http://localhost:8082/sigungu?pid_loc_code=1111000000
- **Response**
    - Type: `JSON`
    - DB에 param과 동일한 데이터들을 리스트로 출력
      - Example Data
          ```json
          [
            {
            "pidLocCode": 1111000000,
            "level": 2,
            "depth1": "서울특별시",
            "depth2": "종로구",
            "depth3": "none",
            "ltLng": 126.948899,
            "ltLat": 37.56582,
            "rbLng": 127.023365,
            "rbLat": 37.632375,
            "dateCreation": "2018-08-24 15:16:24.0"
            }
          ]
        ```
---
**4. 사용자 데이터 생성 API 개발**
- **Endpoint**: `/user`
- **Method**: `POST`
- **Request Body**
    - Type: `JSON`
    - Example Fields
        - `name`: `String`
        - `password`: `String`
    - Example Data
        ```json
        {
            "name": "test",
            "password": "test1234"
        }
        ```

- **Response**
    - Type: `JSON`
    - 삽입된 데이터와 message 리턴
      - Response sample
        ```json
        {
          "message": "User successfully created",
          "user": {
              "id": 2,
              "name": "test",
              "password": "test1234",
              "createdAt": "2025-04-08T09:39:07.581136"
              }
        }
        ```
---
**5. 데이터 구조화 및 API 개발**
- **Endpoint**: `/floorPlans/search`
- **Method**: `GET`
- **Request Params**
    - `{name}`: APT단지명
    - `{addressType}`: 주소형식 (ROAD : 도로명/ JIBUN : 지번)
    - `{addressKeyword}`: 검색 주소
    - `{isExtended}`: 확장여부 (0/1)
    - `{unitName}`: 유닛명 (ex. 84B)
    - `{exclusiveAreaSort}`: 전용면적정렬방식 (asc / desc)
  
    - Example

        http://localhost:8082/floorPlans/search?name=고덕아르테온&addressType=ROAD&addressKeyword=360&exclusiveAreaSort=asc
        

- **Response**
    - Type: `JSON`
    - `{complexName}`: APT단지명
    - `{unitName}`: 유닛명 (ex. 84B)
    - `{exclusiveArea}`: 전용면적
    - `{isExtended}` : 확장여부 (T/F)
    - `{imageUrl}` : 이미지 URL
    - 삽입된 데이터 리턴
- Response Sample
  ```json
  {
      "complexName":"고덕아르테온",
      "unitName":"80D",
      "exclusiveArea":59.83,
      "isExtended":false,
      "imageUrl":"https://ic.zigbang.com/ic/floor..."
  }
  ```
---
**ETC.기타**
ERD경로
`src/main/resources/static/ERD.drawio.jpg`
실행방식
압축해제 및 InteliJ 프로젝트 open - gradle빌드 - 실행 