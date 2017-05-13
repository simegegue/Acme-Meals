
package converters;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import repositories.PromoteRepository;
import domain.Promote;

@Component
@Transactional
public class StringToPromoteConverter implements Converter<String, Promote> {

	@Autowired
	PromoteRepository	promoteRepository;


	@Override
	public Promote convert(final String text) {
		Promote result;
		int id;

		try {
			if (StringUtils.isEmpty(text))
				result = null;
			else {
				id = Integer.valueOf(text);
				result = this.promoteRepository.findOne(id);
			}
		} catch (final Exception oops) {
			throw new IllegalArgumentException(oops);
		}

		return result;
	}

}
