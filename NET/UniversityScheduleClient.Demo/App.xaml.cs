using Livet;
using System.Windows;

namespace Mntone.UniversityScheduleClient.Demo
{
	public partial class App
		: Application
	{
		protected override void OnStartup( StartupEventArgs e )
		{
			base.OnStartup( e );
			DispatcherHelper.UIDispatcher = this.Dispatcher;
		}
	}
}