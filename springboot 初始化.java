SpringApplication:
	private void initialize(Object[] sources) {
		if (sources != null && sources.length > 0) {
			this.sources.addAll(Arrays.asList(sources));
		}
		this.webEnvironment = deduceWebEnvironment();

		// 从spring.factories里读取所有 ApplicationContextInitializer，并记入 SpringApplication
		setInitializers((Collection) getSpringFactoriesInstances(
				ApplicationContextInitializer.class));

		// 从spring.factories里读取所有 ApplicationListener，并记入 SpringApplication
		setListeners((Collection) getSpringFactoriesInstances(ApplicationListener.class));

		this.mainApplicationClass = deduceMainApplicationClass();
	}

	public ConfigurableApplicationContext run(String... args) {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		ConfigurableApplicationContext context = null;
		FailureAnalyzers analyzers = null;
		configureHeadlessProperty();

		// 从spring.factories里读取所有 SpringApplicationRunListener，监听springboot启动，参考：org.springframework.boot.context.event.EventPublishingRunListener
		SpringApplicationRunListeners listeners = getRunListeners(args);
		listeners.starting();
		try {
			ApplicationArguments applicationArguments = new DefaultApplicationArguments(
					args);
			ConfigurableEnvironment environment = prepareEnvironment(listeners,
					applicationArguments);
			Banner printedBanner = printBanner(environment);

			// web环境下默认的 ApplicationContext： org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext
			// 非web环境下默认的 ApplicationContext： org.springframework.context.annotation.AnnotationConfigApplicationContext
			context = createApplicationContext();
			analyzers = new FailureAnalyzers(context);

			// org.springframework.cloud.bootstrap.config.PropertySourceBootstrapProperties 会通过 ApplicationContextInitializer，准备 PropertySource
			// PropertySourceBootstrapProperties 收集 PropertySourceLocator 来获得PropertySource
			// 其中 org.springframework.cloud.config.client.ConfigServicePropertySourceLocator 是 Cloud Config Client 提供的 PropertySourceLocator
			prepareContext(context, environment, listeners, applicationArguments,
					printedBanner);

			// 调用 context.refresh
			refreshContext(context);

			
			afterRefresh(context, applicationArguments);
			listeners.finished(context, null);
			stopWatch.stop();
			if (this.logStartupInfo) {
				new StartupInfoLogger(this.mainApplicationClass)
						.logStarted(getApplicationLog(), stopWatch);
			}
			return context;
		}
		catch (Throwable ex) {
			handleRunFailure(context, listeners, analyzers, ex);
			throw new IllegalStateException(ex);
		}
	}