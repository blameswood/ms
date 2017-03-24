## Docker Compose
Compose ��һ�����ڶ�������ж�������DockerӦ�õĹ��ߡ�
ʹ��Compose���������һ�������ļ���yaml��ʽ����������Ӧ�õķ���Ȼ��ʹ��һ��������ɴ������������������õ����з���

### docker-compose.yml��������
image

ָ���������ƻ��߾���id������þ����ڱ��ز����ڣ�Compose�᳢��pull������

ʾ����

image: java
build

ָ��Dockerfile�ļ���·����������һ��·�������磺

build: ./dir
Ҳ������һ����������ָ��Dockerfile�Ͳ��������磺

build:
  context: ./dir
  dockerfile: Dockerfile-alternate
  args:
    buildno: 1
command

��������������Ĭ��ִ�е����

ʾ����

command: bundle exec thin -p 3000
Ҳ������һ��list��������Dockerfile�ܵ�CMDָ���ʽ���£�

command: [bundle, exec, thin, -p, 3000]
links

���ӵ����������е�����������ָ���������ƺ����ӵı���ʹ��SERVICE:ALIAS ����ʽ������ָֻ���������ƣ�ʾ����

web:
  links:
   - db
   - db:database
   - redis
external_links

��ʾ���ӵ�docker-compose.yml�ⲿ����������������Compose������������ر��Ƕ�����Щ�ṩ����������ͬ���񡣸�ʽ��links���ƣ�ʾ����

external_links:
 - redis_1
 - project_db_1:mysql
 - project_db_1:postgresql
ports

��¶�˿���Ϣ��ʹ�������˿�:�����˿ڵĸ�ʽ�����߽���ָ�������Ķ˿ڣ���ʱ�������������ָ���˿ڣ���������docker run -p ��ʾ����

ports:
 - "3000"
 - "3000-3005"
 - "8000:8000"
 - "9090-9091:8080-8081"
 - "49100:22"
 - "127.0.0.1:8001:8001"
 - "127.0.0.1:5000-5010:5000-5010"
expose

��¶�˿ڣ�ֻ���˿ڱ�¶�����ӵķ��񣬶�����¶����������ʾ����

expose:
 - "3000"
 - "8000"
volumes

�����·�����á���������������·�� ��HOST:CONTAINER�� ����Ϸ���ģʽ ��HOST:CONTAINER:ro����ʾ����

volumes:
  # Just specify a path and let the Engine create a volume
  - /var/lib/mysql

  # Specify an absolute path mapping
  - /opt/data:/var/lib/mysql

  # Path on the host, relative to the Compose file
  - ./cache:/tmp/cache

  # User-relative path
  - ~/configs:/etc/configs/:ro

  # Named volume
  - datavolume:/var/lib/mysql
volumes_from

����һ����������������ؾ�����ָ��ֻ�����߿ɶ�д���������ģʽû��ָ������Ĭ���ǿɶ�д��ʾ����

volumes_from:
 - service_name
 - service_name:ro
 - container:container_name
 - container:container_name:rw
environment

���û�������������ʹ����������ֵ����ַ�ʽ��ֻ��һ��key�Ļ�����������������Compose�Ļ������ҵ���Ӧ��ֵ���������ڼ��ܵĻ�������������ֵ��ʾ����

environment:
  RACK_ENV: development
  SHOW: 'true'
  SESSION_SECRET:

environment:
  - RACK_ENV=development
  - SHOW=true
  - SESSION_SECRET
env_file

���ļ��л�ȡ��������������Ϊ�������ļ�·�����б����ͨ�� docker-compose -f FILE ָ����ģ���ļ����� env_file ��·�������ģ���ļ�·��������б��������� environment ָ���ͻ������envirment Ϊ׼��ʾ����

env_file: .env

env_file:
  - ./common.env
  - ./apps/web.env
  - /opt/secrets.env
extends

�̳���һ�����񣬻������еķ��������չ��

net

��������ģʽ��ʾ����

net: "bridge"
net: "host"
net: "none"
net: "container:[service name or container name/id]"
dns

����dns��������������һ��ֵ��Ҳ������һ���б�ʾ����

dns: 8.8.8.8
dns:
  - 8.8.8.8
  - 9.9.9.9
dns_search

����DNS�������򣬿�����һ��ֵ��Ҳ������һ���б�ʾ����

dns_search: example.com
dns_search:
  - dc1.example.com
  - dc2.example.com

### compose��������

�󲿷��������������һ�����������ϡ����û���ر��˵����������Ӧ������Ŀ���еķ����ϡ�

ִ�� docker-compose [COMMAND] --help �鿴����ĳ�������ʹ��˵����

������ʹ�ø�ʽ��

docker-compose [options] [COMMAND] [ARGS...]
ѡ��
--verbose ������������Ϣ��
--version ��ӡ�汾���˳���
-f, --file FILE ʹ���ض��� compose ģ���ļ���Ĭ��Ϊ docker-compose.yml��
-p, --project-name NAME ָ����Ŀ���ƣ�Ĭ��ʹ��Ŀ¼���ơ�
����
build

���������¹�������

����һ�������󣬽������һ������������� web_db��

������ʱ����ĿĿ¼������ docker-compose build �����¹�������

help

���һ������İ�����

kill

ͨ������ SIGKILL �ź���ǿ��ֹͣ����������֧��ͨ��������ָ�����͵��źţ�����

$ docker-compose kill -s SIGINT
logs

�鿴����������

port

��ӡ�󶨵Ĺ����˿ڡ�

ps

�г�����������

pull

��ȡ������

rm

ɾ��ֹͣ�ķ���������

run

��һ��������ִ��һ�����

���磺

$ docker-compose run ubuntu ping docker.com
��������һ�� ubuntu ����ִ�� ping docker.com ���

Ĭ������£����й����ķ��񽫻��Զ���������������Щ�����Ѿ��������С�

������������������������ָ���������ؾ����ӵȵȶ����ᰴ������������

������ͬ�㣺

��������Ḳ��ԭ�е��Զ��������
�����Զ������˿ڣ��Ա����ͻ��
�����ϣ���Զ���������������������ʹ�� --no-deps ѡ�����

$ docker-compose run --no-deps web python manage.py shell
���������� web ����������������������

scale

����ͬһ���������е�����������

ͨ�� service=num �Ĳ������������������磺

$ docker-compose scale web=2 worker=3
start

����һ���Ѿ����ڵķ���������

stop

ֹͣһ���Ѿ����е�����������ɾ������ͨ�� docker-compose start �����ٴ�������Щ������

up

�����������£�����������������һ��������ص�������

���ӵķ��񶼽������������������Ѿ����С�

Ĭ������� docker-compose up ����������������������������˳�ʱ��������������ֹͣ��

���ʹ�� docker-compose up -d �������ں�̨�������������е�������

Ĭ�����������÷���������Ѿ����ڣ� docker-compose up ����ֹͣ���������´������ǣ�����ʹ�� volumes-from ���صľ����Ա�֤ docker-compose.yml ���޸���Ч������㲻��������ֹͣ�����´���������ʹ�� docker-compose up --no-recreate�������Ҫ�Ļ����������������Ѿ�ֹͣ��������

��������
�������������������� Compose ����Ϊ��

��DOCKER_��ͷ�ı������������� Docker �����пͻ��˵�ʹ��һ�������ʹ�� boot2docker , $(boot2docker shellinit) ������������Ϊ��ȷ��ֵ��

COMPOSE_PROJECT_NAME

����ͨ�� Compose ������ÿһ������ǰ��ӵ���Ŀ���ƣ�Ĭ���ǵ�ǰ����Ŀ¼�����֡�

COMPOSE_FILE

����Ҫʹ�õ� docker-compose.yml ��·����Ĭ��·���ǵ�ǰ����Ŀ¼��

DOCKER_HOST

���� Docker daemon �ĵ�ַ��Ĭ��ʹ�� unix:///var/run/docker.sock���� Docker �ͻ��˲��õ�Ĭ��ֵһ�¡�

DOCKER_TLS_VERIFY

������ò�Ϊ�գ����� Docker daemon ����ͨ�� TLS ���С�

DOCKER_CERT_PATH

���� TLS ͨ������Ҫ����֤��ca.pem��cert.pem �� key.pem���ļ���·����Ĭ���� ~/.docker ��


### ʹ��Docker Compose������Ŀ
#### 1.׼������    
����Ŀ�����Docker���񡣿���ʹ��Docker��Maven�������Ŀ�����Docker����Ҳ����ʹ��Dockerfile����������ʽ�����  
Maven���  
* ��pom����Ӳ������

```xml
    <pluginManagement>
      <plugins>
        <plugin>
          <groupId>com.spotify</groupId>
          <artifactId>docker-maven-plugin</artifactId>
          <version>0.4.12</version>
        </plugin>
      </plugins>
    </pluginManagement>
```

* Ȼ��������Ŀ����������ݣ�

```xml
  <build>
    <plugins>
      <plugin>
        <groupId>com.spotify</groupId>
        <artifactId>docker-maven-plugin</artifactId>
        <executions>
          <execution>
            <id>build-image</id>
            <phase>package</phase>
            <goals>
              <goal>build</goal>
            </goals>
          </execution>
        </executions>
        <configuration>
          <imageName>${docker.image.prefix}/${project.artifactId}</imageName>
          <baseImage>java</baseImage>
          <entryPoint>["java", "-jar", "/${project.build.finalName}.jar"]</entryPoint>
          <resources>
            <resource>
              <targetPath>/</targetPath>
              <directory>${project.build.directory}</directory>
              <include>${project.build.finalName}.jar</include>
            </resource>
          </resources>
        </configuration>
      </plugin>
    </plugins>
  </build>
```

* �ڸ���Ŀ����·���£�ִ�����


```shell
mvn clean package
```

��������Ŀ�ͻ�Ϊ������Ŀ�����jar���������Զ�������Docker����

#### 2.��дdocker-compose.yml�ļ�

#### 3.��������������Ų�

������docker-compose.yml����·��ִ�У�

```shell
docker-compose up
```