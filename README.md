# Instrumentação Datadog Trace Agent build via JIB Google (Maven)

## Agent container
Incluir o container do agente na mesma rede da aplicação

``` 
docker run -d --name datadog-agent \
              --network <NETWORK_NAME> \
              --cgroupns host \
              --pid host \
              -v /var/run/docker.sock:/var/run/docker.sock:ro \
              -v /proc/:/host/proc/:ro \
              -v /sys/fs/cgroup/:/host/sys/fs/cgroup:ro \
              -v /var/run/datadog/:/var/run/datadog/ \
              -e DD_API_KEY=<API_KEY_DATADOG> \
              -e DD_APM_ENABLED=true \
              -e DD_SITE="<SITE_DATADOG>" \
              -e DD_APM_NON_LOCAL_TRAFFIC=true \
              -e DD_APM_RECEIVER_SOCKET=/var/run/datadog/apm.socket \
              gcr.io/datadoghq/agent:latest
```

## JVM options/variaveis

Editar no campo plugin do arquivo POM.xml

 ```
 <container>
    <jvmFlags>
        <jvmFlag>-javaagent:/app/libs/dd-java-agent.jar</jvmFlag>
	    <jvmFlag>-XX:FlightRecorderOptions=stackdepth=256</jvmFlag>
	    <jvmFlag>-Ddd.service=SERVICO</jvmFlag>
	    <jvmFlag>-Ddd.env=AMBIENTE</jvmFlag>
	    <jvmFlag>-Ddd.logs.injection=true</jvmFlag>
	    <jvmFlag>-Ddd.agent.host=datadog-agent</jvmFlag>
	    <jvmFlag>-Ddd.agent.port=8126</jvmFlag>
    </jvmFlags>
<container>
```

## Incluir o agent tracer na imagem do container

Download do agent https://dtdg.co/latest-java-tracer criar um diretório com o nome ddagent e incluir no repositório 

```
<extraDirectories>
    <paths>
	    <path>
	    	<from>ddagent</from>
	    	<into>/app/libs</into>
        </path>
    </paths> <!-- Copies files from 'src/custom-extra-dir' -->
    <permissions>
	    <permission>
		    <file>/libs/dd-java-agent.jar</file>
		    <mode>755</mode>
	    </permission>
    </permissions>
</extraDirectories>
```