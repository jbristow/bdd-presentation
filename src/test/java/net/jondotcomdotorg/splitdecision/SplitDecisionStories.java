package net.jondotcomdotorg.splitdecision;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.core.reporters.Format.HTML;
import static org.jbehave.core.reporters.Format.XML;

import java.net.URL;
import java.util.List;

import net.jondotcomdotorg.steps.DiceChoiceSteps;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.FilePrintStreamFactory.ResolveToSimpleName;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.MarkUnmatchedStepsAsPending;

public class SplitDecisionStories extends JUnitStories {
	@Override
	public Configuration configuration() {
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
		URL codeLocation = CodeLocations.codeLocationFromClass(this.getClass());
		Configuration configuration = new MostUsefulConfiguration()
				.useStepCollector(new MarkUnmatchedStepsAsPending())
				.useStoryLoader(new LoadFromClasspath(classLoader))
				.useStoryReporterBuilder(
						new StoryReporterBuilder()
								.withCodeLocation(codeLocation)
								.withPathResolver(new ResolveToSimpleName())
								.withDefaultFormats()
								.withFormats(CONSOLE, HTML, XML)
								.withFailureTrace(true));
		return configuration;
	}

	@Override
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(configuration(), new DiceChoiceSteps());
	}

	@Override
	protected List<String> storyPaths() {
		return new StoryFinder().findPaths(
				codeLocationFromClass(this.getClass()).getFile(),
				asList("**/*.story"), null);
	}

}
