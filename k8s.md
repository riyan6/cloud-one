### deployment.yaml
```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: cloud-other
  labels:
    app: cloud-other
spec:
  replicas: 3
  selector:
    matchLabels:
      app: cloud-other
  template:
    metadata:
      labels:
        app: cloud-other
    spec:
      containers:
        - name: my-java-app
          image: cloud-other:1.0
          ports:
            - containerPort: 8686
```
运行命令：`kubectl apply -f deployment.yaml` 部署到一个 Kubernetes 集群。会自动根据配置文件建新的资源，或者更新现有的资源。

1. `metadata.name`：Deployment对象的名字，唯一性，其他的Kubernetes对象（如Services、ReplicaSets等）可以引用这个名称来和该Deployment进行交互。
2. `metadata.labels.app`：一个标签，用于标识属于同一应用的所有Kubernetes对象。你可能有一个应用包含了多个Deployments、Services和Pods，你可以用相同的app标签值来标识它们。
3. `spec.selector.matchLabels.app`：这个字段用于确定由当前Deployment管理的Pods。在这个例子中，任何一个app标签值为my-java-app的Pod都会被这个Deployment管理。**对应着4**
4. `spec.template.metadata.labels.app`: 这是在Pod 的模板中定义的标签。新的Pods在被创建时，会继承这个模板中的所有标签。在这个例子中，所有由此Deployment创建的Pods都会有一个app标签，其值为my-java-app。**对应着3**
5. `spec.template.spec.containers.name`: 这是在Pods内部创建的每个容器的名称。每个容器都必须有一个独特的名字。尽管Pods可能有多个容器，但在多数情况下，一个Pod只会有一个容器。在这个例子中，每个Pod都只有一个名为my-java-app的容器。

### service.yaml
```yaml
apiVersion: v1
kind: Service
metadata:
  name: user-cloud-service
spec:
  selector:
    app: cloud-other
  ports:
    - protocol: TCP
      port: 8686
      targetPort: 8686
  type: LoadBalancer
```
运行命令：`kubectl apply -f service.yaml` 创建一个负载均衡器，并通过公共IP地址暴露你的应用。
这个 Service 定义了一个名为 user-cloud-service 的负载均衡服务，监听 8686 端口，将流量分发到所有 app=cloud-other 标签的 Pod 的 8686 端口。

### Spring Cloud Kubernetes
Spring Cloud Kubernetes 是 Spring Cloud 的一个子项目，它提供了 Spring Cloud 对 Kubernetes 的原生支持。以下是 Spring Cloud Kubernetes 的主要特性：
服务发现： Spring Cloud Kubernetes 可以利用 Kubernetes 的服务注册和发现机制，使得你的 Spring Boot 应用可以自动发现集群中运行的其他微服务，无需额外的服务注册中心。
配置管理： Spring Cloud Kubernetes 可以将 Kubernetes ConfigMap 与 Spring Environment 绑定，允许你通过 Spring 的 @Value 注解来获取 ConfigMap 中的值。同时也支持 ConfigMap 的热更新，更新 ConfigMap 的内容后，你的应用会自动加载新的配置。
负载均衡和断路器： Spring Cloud Kubernetes 集成了 Ribbon 和 Hystrix，可以在 Kubernetes 集群里进行客户端负载均衡和故障转移。
健康检查： Spring Cloud Kubernetes 可以将应用的健康检查信息反馈给 Kubernetes 的 Liveness Probes 和 Readiness Probes，帮助 Kubernetes 更准确地进行服务调度。
领导选举： 如果你的应用需要进行领导选举，Spring Cloud Kubernetes 也提供了相关的支持。
使用 Spring Cloud Kubernetes，你可以很好地将 Spring Cloud 微服务应用部署在 Kubernetes 上，享受 Kubernetes 提供的伸缩、自动恢复、滚动更新等优势，同时又能使用 Spring Cloud 提供的微服务解决方案。